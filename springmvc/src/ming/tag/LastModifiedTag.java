package ming.tag;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TagSupport;

public class LastModifiedTag extends TagSupport {
	private static final long serialVersionUID = -2463956816652901357L;

	public int doEndTag() {
		try {
			HttpServletRequest request = (HttpServletRequest) pageContext
					.getRequest();
			String path = pageContext.getServletContext().getRealPath(
					request.getServletPath());
			File file = new File(path);
			DateFormat formatter = DateFormat.getDateInstance(DateFormat.LONG);
			pageContext.getOut().println(
					formatter.format(new Date(file.lastModified())));
		} catch (IOException ignored) {
		}
		return EVAL_PAGE;
	}
	
}
