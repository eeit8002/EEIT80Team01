package question.model;

import java.util.List;

import question.model.dao.QuestionDAOJdbc;

public class QuestionService {
	public List<QuestionBean> supporterListUnAnsweredQuestions() {
		QuestionDAOJdbc dao = new QuestionDAOJdbc();
		return dao.supporterListUnAnsweredQuestions();
	}

	public boolean memberAskQuestion(String member, String title, String qmsg) {
		QuestionDAOJdbc dao = new QuestionDAOJdbc();
		return dao.memberAskQuestion(member, title, qmsg);
	}

	public QuestionBean supporterQuestionDetail(int qno) {
		QuestionDAOJdbc dao = new QuestionDAOJdbc();
		return dao.supporterQuestionDetail(qno);
	}

	public boolean supporterAnswerQuestion(int qno, String supporter, String amsg) {
		QuestionDAOJdbc dao = new QuestionDAOJdbc();
		return dao.supporterAnswerQuestion(qno, supporter, amsg);
	}

	public List<QuestionBean> memberListUnAnsweredQuestions(String member) {
		QuestionDAOJdbc dao = new QuestionDAOJdbc();
		return dao.memberListUnAnsweredQuestions(member);
	}
	
	public List<QuestionBean> memberListAnsweredQuestions(String member) {
		QuestionDAOJdbc dao = new QuestionDAOJdbc();
		return dao.memberListUnAnsweredQuestions(member);
	}
	
	public QuestionBean memberUnansweredQuestionDetail(String member, int qno) {
		QuestionDAOJdbc dao = new QuestionDAOJdbc();
		return dao.memberUnansweredQuestionDetail(member, qno);
	}
	
	public QuestionBean memberAnsweredQuestionDetail(String member, int qno) {
		QuestionDAOJdbc dao = new QuestionDAOJdbc();
		return dao.memberAnsweredQuestionDetail(member, qno);
	}
}
