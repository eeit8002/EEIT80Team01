package member.model;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<MessageBean> findBySender(String sender){
		List<MessageBean> list = new ArrayList<MessageBean>();
		MessageDAO dao = new MessageDAOjdbc();
		list = dao.findBySender(sender);		
		return list;
	}
	
	public List<MessageBean> findByReceiver(String receiver){
		List<MessageBean> list = new ArrayList<MessageBean>();
		MessageDAO dao = new MessageDAOjdbc();
		list = dao.findByReceiver(receiver);		
		return list;
	}
	
}
