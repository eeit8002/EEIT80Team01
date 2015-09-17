package question.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import global.GlobalService;
import question.model.QuestionBean;

public class QuestionDAOJdbc {
	private DataSource ds = null;

	public QuestionDAOJdbc() {
		Context context = null;
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup(GlobalService.JNDI_DB_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/* SUPPOTER AREA */
	// supporter list unanswered questions
	private static final String UNREPLY_QUESTIONS = "SELECT QNO,MEMBER,TITLE,MSG from QUESTION WHERE SUPPORTER IS NULL";

	public List<QuestionBean> getUnAnsweredQuestions() {
		List<QuestionBean> qbl = null;
		try (Connection connection = ds.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(UNREPLY_QUESTIONS);) {
			ResultSet rs = pstmt.executeQuery();
			qbl = new ArrayList<QuestionBean>();
			while (rs.next()) {
				QuestionBean qb = new QuestionBean();
				qb.setQno(rs.getString("QNO"));
				qb.setMember(rs.getString("MEMBER"));
				qb.setTitle(rs.getString("TITLE"));
				qb.setMsg(rs.getString("MSG"));
				qbl.add(qb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qbl;
	}

	// supporter answer question
	private static final String SUPPORT_REPLY_QUESTION = "UPDATE SUPPORT_QUESTION SET SUPPORTER=?,MSG=? WHERE QNO=?";

	public boolean supporterAnswerQuestion(int qno, String supporter, String msg) {
		boolean result = false;
		try (Connection connection = ds.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SUPPORT_REPLY_QUESTION);) {
			pstmt.setString(1, supporter);
			pstmt.setString(2, msg);
			pstmt.setInt(3, qno);
			result = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String QUESTION_DETAIL = "SELECT MEMBER,TITLE,MSG WHERE QNO=?";

	public QuestionBean supporterQuestionDetail(int qno) {
		QuestionBean result = null;
		try (Connection connection = ds.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(QUESTION_DETAIL);) {
			pstmt.setInt(1, qno);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new QuestionBean();
				result.setMember(rs.getString("MEMBER"));
				result.setTitle(rs.getString("TITLE"));
				result.setMsg(rs.getString("MSG"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* SUPPORTER AREA */

	/* MEMBER AREA */
	// member ask question
	private static final String MEMBER_NEW_QUESTION = "INSERT INTO SUPPORT_QUESTION SET MEMBER=?,TITLE=?,MSG=?";

	public boolean memberAskQuestion(String member, String title, String msg) {
		boolean result = false;
		try {
			Connection connection = ds.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(MEMBER_NEW_QUESTION);
			pstmt.setString(1, member);
			pstmt.setString(2, title);
			pstmt.setString(3, msg);
			result = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// member list answered questions
	private static final String MEMBER_LIST_ANSWERED_QUESTIONS = "SELECT QNO,SUPPORTER,TITLE,MSG FROM SUPPORT_QUESTION WHERE MEMBER=? AND SUPPORTER IS NOT NULL AND ORDER BY QNO DESC";

	public List<QuestionBean> memberListAnsweredQuestions(String member) {
		List<QuestionBean> qbl = new ArrayList<QuestionBean>();
		try (Connection connection = ds.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(MEMBER_LIST_ANSWERED_QUESTIONS);) {
			pstmt.setString(1, member);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				QuestionBean qb = new QuestionBean();
				qb.setQno(rs.getString("QNO"));
				qb.setSupporter(rs.getString("SUPPORTER"));
				qb.setTitle(rs.getString("TITLE"));
				qb.setMsg(rs.getString("MSG"));
				qbl.add(qb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qbl;
	}

	// member list unanswered questions
	private static final String MEMBER_LIST_UNANSWERED_QUESTIONS = "SELECT QNO,TITLE,MSG FROM SUPPORT_QUESTION WHERE MEMBER=? AND SUPPORTER IS NULL AND ORDER BY QNO DESC";

	public List<QuestionBean> memberListUnAnsweredQuestions(String member) {
		List<QuestionBean> qbl = new ArrayList<QuestionBean>();
		try (Connection connection = ds.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(MEMBER_LIST_UNANSWERED_QUESTIONS);) {
			pstmt.setString(1, member);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				QuestionBean qb = new QuestionBean();
				qb.setQno(rs.getString("QNO"));
				qb.setTitle(rs.getString("TITLE"));
				qb.setMsg(rs.getString("MSG"));
				qbl.add(qb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qbl;
	}
}
