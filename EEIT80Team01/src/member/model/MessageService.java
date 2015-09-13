package member.model;

import member.model.dao.MessageDAOjdbc;

public class MessageService {
	public MessageService(){
		
	}
	public MessageBean addNewMessage(MessageBean bean){
		MessageDAO dao = new MessageDAOjdbc();
		MessageBean result = dao.insert(bean);
		
		return result;
	}
	
	public MessageBean findMessageByMessageno(long messageNumber){
		MessageDAO dao = new MessageDAOjdbc();
		MessageBean result = dao.select(messageNumber); 
		return result;
	}
	
	
}
