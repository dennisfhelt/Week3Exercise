package edu.matc.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Extends a greeting that depends on whether it's Feb 2nd
 */
public class GroundhogTag extends SimpleTagSupport {
    private LocalDateTime dateTime = LocalDateTime.now();

    /**
     * Feb 2? - Happy Groundhog's Day!
     * not Feb2 - Sorry.
     *
     * @throws JspException
     * @throws IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        if (dateTime.getDayOfYear() == 33) {
            out.println("Happy Groundhog's Day!");

        } else {
            out.println("Sorry it's not Groundhog's Day");
        }
    }
}
