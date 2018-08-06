package com.mi.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@ServerEndpoint(value = "/communication")
public class CommunicationWebSocket {

	private Session session;
	private int type = 0;
	private int userAccount = 0;
	private int employeeAccount = 0;
	private int empToCus[] = new int[5];
	private static final Set<CommunicationWebSocket> connections = new CopyOnWriteArraySet<CommunicationWebSocket>();

	@OnOpen
	public void start(Session session) {
		this.session = session;
		System.out.println("opened");
	}

	@OnClose
	public void end() {
		if (type == 1) {
			System.out.println(this.userAccount + "断开连接");
			if (employeeAccount != 0) {
				for (CommunicationWebSocket c : connections) {
					if (c.type == 2 && c.employeeAccount == employeeAccount) {
						for (int i = 0; i < c.empToCus.length; i++) {
							if (c.empToCus[i] == userAccount) {
								c.empToCus[i] = 0;
								Gson gson = new Gson();
								Map<String, Object> t = new HashMap<>();
								t.put("state", "close");
								t.put("message", userAccount);
								t.put("account", userAccount);
								String text = gson.toJson(t);
								synchronized (c) {
									try {
										c.session.getBasicRemote().sendText(text);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
						}
					}
				}
			}
			connections.remove(this);
		} else if (type == 2) {
			System.out.println(this.employeeAccount + "断开连接");
			for (CommunicationWebSocket c : connections) {
				if (c.type == 1 ) {
					for (int i = 0; i < c.empToCus.length; i++) {
						if (c.userAccount == empToCus[i] ) {
							c.employeeAccount = 0;
							Gson gson = new Gson();
							Map<String, Object> t = new HashMap<>();
							t.put("state", "close");
							t.put("message", employeeAccount);
							t.put("account", employeeAccount);
							String text = gson.toJson(t);
							synchronized (c) {
								try {
									c.session.getBasicRemote().sendText(text);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}

				}
			}
			connections.remove(this);
		} else {
			connections.remove(this);
		}
	}

	public void testConnection() {
		for (CommunicationWebSocket c : connections) {
			System.out.println("type:"+type+" userAccount:"+userAccount+" employeeId:"+employeeAccount);
		}
	}
	
	@OnMessage
	public void inComing(String message) {
		System.out.println(message);
		Gson gson = new Gson();
		Map<String, Object> map = gson.fromJson(message, new TypeToken<HashMap<String, Object>>() {
		}.getType());

		String state = (String) map.get("state");
		if (state == null || state.equals("")) {
			synchronized (this) {
				try {
					Map<String, Object> t = new HashMap<>();
					t.put("state", "error");
					t.put("message", "未知错误");
					String text = gson.toJson(t);
					session.getBasicRemote().sendText(text);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return;
		}
		switch (state) {
		case "record":
			int account = Integer.parseInt((String)map.get("account"));
			String msg = (String) map.get("message");
			if (type == 1) {
				sendMessage(type, userAccount, account, msg);
			} else if (type == 2) {
				sendMessage(type, employeeAccount, account, msg);
			}

			break;
		case "start":
			int account1 = Integer.parseInt((String)map.get("account"));
			int type = Integer.parseInt((String)map.get("type"));
			this.type = type;
			if (type == 1) {
				if (checkDuplicateUser(account1, this)) {
					try {
						session.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;
				}
				userAccount = account1;
			} else if (type == 2) {
				employeeAccount = account1;
			}
			connections.add(this);
			testConnection();
			if (type == 1) {
				matchStaff(account1, this);
			}
			break;

		}
	}

	@OnError
	public void onError(Throwable t) throws Throwable {
		t.printStackTrace();
	}

	private static boolean checkDuplicateUser(int account, CommunicationWebSocket socket) {
		for (CommunicationWebSocket c : connections) {
			if (c.type == 1 && c.userAccount == account) {
				Map<String, Object> t = new HashMap<>();
				t.put("state", "error");
				t.put("message", "重复的请求客服");
				String text = new Gson().toJson(t);
				synchronized (socket) {
					try {
						socket.session.getBasicRemote().sendText(text);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return true;
			}
		}
		return false;
	}

	private static void matchStaff(int account, CommunicationWebSocket socket) {
		for (CommunicationWebSocket c : connections) {
			if (c.type == 2) {
				for (int i = 0; i < c.empToCus.length; i++) {
					if (c.empToCus[i] == 0) {
						c.empToCus[i] = account;
						Gson gson = new Gson();
						Map<String, Object> t = new HashMap<>();
						t.put("state", "match");
						t.put("message", c.employeeAccount);
						String text = gson.toJson(t);
						synchronized (socket) {
							try {
								socket.session.getBasicRemote().sendText(text);
								socket.employeeAccount = c.employeeAccount;
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						t.put("message", socket.userAccount);
						text = gson.toJson(t);
						synchronized (c) {
							try {
								c.session.getBasicRemote().sendText(text);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						return;
					}
				}
			}
		}
		Gson gson = new Gson();
		Map<String, Object> t = new HashMap<>();
		t.put("state", "matchFail");
		t.put("message","暂无客服空闲");
		String text = gson.toJson(t);
		synchronized (socket) {
			try {
				socket.session.getBasicRemote().sendText(text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void sendMessage(int type, int accountFrom, int accountTo, String msg) {
		if (type == 1) {
			for (CommunicationWebSocket c : connections) {
				if (c.type == 2 && c.employeeAccount == accountTo) {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Gson gson = new Gson();
					Map<String, Object> t = new HashMap<>();
					t.put("state", "record");
					t.put("message", msg);
					t.put("date", format.format(new Date()));
					t.put("account", accountFrom);
					String text = gson.toJson(t);
					synchronized (c) {
						try {
							c.session.getBasicRemote().sendText(text);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		} else if (type == 2) {
			for (CommunicationWebSocket c : connections) {
				if (c.type == 1 && c.userAccount == accountTo) {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Gson gson = new Gson();
					Map<String, Object> t = new HashMap<>();
					t.put("state", "record");
					t.put("message", msg);
					t.put("date", format.format(new Date()));
					t.put("account", accountFrom);
					String text = gson.toJson(t);
					synchronized (c) {
						try {
							c.session.getBasicRemote().sendText(text);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

}
