//public class Test {
//
//	public static void main(String[] args) throws JSONException {
//		RequestHandler handler = JSONClient.connect(8080, "localhost");
//		 JSONObject json1 = new JSONObject();
//		 json1.put("userId", "13202355181");
//		 json1.put("type", "login");
//		 json1.put("password", "123456");
//		 System.out.println(handler.requestForResult(json1));
//
//		JSONObject json = new JSONObject();
//		json.put("userId", "13202355181");
//		json.put("type", "file");
//		json.put("url", "C:\\Users\\陈康勇\\Desktop\\01.jpg");
//		System.out.println(handler.requestForResult(json));
//		handler.closeConnection();
//		JSONClient.shutdown();
//	}
//}
