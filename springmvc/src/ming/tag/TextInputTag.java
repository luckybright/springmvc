package ming.tag;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

public class TextInputTag extends TagSupport {

	private static final long serialVersionUID = -3451527101072326720L;

	public int doEndTag(){
		try {
			pageContext.getOut().println("<input type=\"text\" value=\"tag test\">");
		} catch (IOException ignored) {
		}
		return EVAL_PAGE;
	}
}
