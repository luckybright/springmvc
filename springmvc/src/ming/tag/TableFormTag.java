package ming.tag;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

public class TableFormTag extends TagSupport {
	private static final long serialVersionUID = 4413127515990076611L;

	private String columnNames;
	private String columnEchoNames;
	private String action;
	private String method;
	private String id;
	private String cssClass;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String columnNames) {
		this.columnNames = columnNames;
	}

	public String getColumnEchoNames() {
		return columnEchoNames;
	}

	public void setColumnEchoNames(String columnEchoNames) {
		this.columnEchoNames = columnEchoNames;
	}

	public int doStartTag(){
		String values[] = getColumnEchoNames().split(",");
		try {
			StringBuffer head = new StringBuffer();
			head.append("<thead>");
			appendTd(values, head);
			head.append("</thead>");
			
			//tbody tr td input name="values[i]" td tr tbody
			StringBuffer body = new StringBuffer();
			values = getColumnNames().split(",");
			appendTd(values, body);
			
			StringBuffer table = new StringBuffer();
			table.append("<table>").append(head).append("<tbody>").append(body).append("</tbody></table>");
			
			StringBuffer form = new StringBuffer();
			form.append("<form id=\"").append(getId()).append("\" ");
			if (null != getCssClass()){
				form.append(" class=\"").append(getCssClass()).append("\" ");
			}
			form.append(" action=\"").append(getAction()).append("\" ");
			if (null != getMethod()){
				form.append(" method=\"").append(getMethod()).append("\">");
			} else {
				form.append(" method=\"post\">");
			}
			form.append(table).append("<input type='submit' value='�ύ'></form>");
			pageContext.getOut().println();
		} catch (IOException ignored) {
		}
		return EVAL_PAGE;
	}

	private void appendTd(String[] values, StringBuffer sb) {
		sb.append("<tr>");
		for ( int i = 0; i < values.length; i++){
			sb.append("<td>").append(values[i]).append("</td>");
		}
		sb.append("</tr>");
	}
	
	
}
