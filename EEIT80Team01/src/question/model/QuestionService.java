package question.model;

import java.util.List;

import question.model.dao.QuestionDAOJdbc;

public class QuestionService {
	public List<QuestionBean> supporterListUnAnsweredQuestions() {
		List<QuestionBean> result = new QuestionDAOJdbc().getUnAnsweredQuestions();
		return result;
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
}
