package question.model;

public class QuestionBean {
	private int qno;
	private String member;
	private String title;
	private String qmsg;
	private long qt;
	private String amsg;
	private long at;
	private String supporter;
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQmsg() {
		return qmsg;
	}
	public void setQmsg(String qmsg) {
		this.qmsg = qmsg;
	}
	public long getQt() {
		return qt;
	}
	public void setQt(long qt) {
		this.qt = qt;
	}
	public String getAmsg() {
		return amsg;
	}
	public void setAmsg(String amsg) {
		this.amsg = amsg;
	}
	public long getAt() {
		return at;
	}
	public void setAt(long at) {
		this.at = at;
	}
	public String getSupporter() {
		return supporter;
	}
	public void setSupporter(String supporter) {
		this.supporter = supporter;
	}
}
