package chat.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframwork.stereotype.Component;
import org.springframwork.web.socket.CloserStatus;
import org.springframwork.web.socket.TextMessage;
import org.springframwork.web.socket.WebSocketSession;
import org.springframwork.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.util.JSONPObject;


public class MatchingHandler {

@Component
public class MyHandler extends TextWebSocketHandler {
	// 연결 요청 처리
	// 메시지 받기, 메시지 전달

	// WebSocketSession 클라언트 당 하나씩 생성, 해당 클라이언트와 연결된 웹소켓을 이용할수 있는 객체
	// 해당 객체를 통해 메시지를 주고 받음

	private List<WebSocketSession> users;
	private Map<String, Object> userMap;

	public MyHandler() {
		users = new ArrayList<WebSocketSession>();
		userMap = new HashMap<String, Object>();
	}

	@Override
			//소켓 연결 생성 후 실행 메서드
		public void afterConnectionestablished(WebSocketSession session) throw Exception{
			System.out.println("TextWebSocketHandler : 연결 생성!");
		users.add(session);
	}

	@Override
			//메시지 수신 후 실행 메서드
		protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
		System.out.println("TextWebSocketHandler : 메시지 수신!");
		System.out.println("메시지 : " +message.getPayload());
		JSONObject object = new JSONObject(message.getPayland());
		String type = object.getString("type");
		
		if(type != null && type.equals("register")) {
			// 등록 요청 메시지
			String user = object.getString("userid");
			// 아이디랑 Session이랑 매핑 >>> Map
			userMap.put(user, session);
		} else {
			//채팅 메시지 : 상대방 아이디를 포함해서 메시지를 보낼것이기 때문에
			//Map에서 상대방 아이디에 해당하는 WebSocket 꺼내와서 메시지 전송
			String target = object.getString("target");
			WebSocketSession ws = (WebSocketSession)userMap.get(target);
			String msg = object.getString("message");
			if(ws != null) {
				ws.sendMessage(new TextMessage(msg));
			}
					
		}
		}

	@Override
			// 연결 해제 후 실행 메서드
		public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throw Exception {
			System.out.println("TextWebSocketHandler : 연결 종료!");
			users.remove(session);
		}
	
	
		}
