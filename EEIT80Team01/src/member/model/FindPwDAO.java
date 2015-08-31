package member.model;
import java.util.List;


public interface FindPwDAO {
	
	public abstract FindPwBean select(String userName);

	public abstract List<FindPwBean> select();

	public abstract FindPwBean insert(FindPwBean bean);

	public abstract FindPwBean update(FindPwBean bean);

	public abstract boolean delete(String userName);
	
	
}
