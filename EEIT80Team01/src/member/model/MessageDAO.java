package member.model;
import java.util.List;



public interface MessageDAO {

	public abstract MessageBean select(long messageNumber);

	public abstract List<MessageBean> findBySender(String sender);

	public abstract List<MessageBean> findByReceiver(String receiver);
	
	public abstract MessageBean insert(MessageBean bean);

	public abstract MessageBean update(MessageBean bean);

	public abstract boolean delete(long messageNumber);
	
}
