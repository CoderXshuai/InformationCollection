package action;


import com.opensymphony.xwork2.ModelDriven;
import model.Doc;
import org.junit.Test;
import service.DocService;
import util.MyUtils;

/**
 * @author CoderXshuai
 */
public class DocAction implements ModelDriven<Doc> {
    private final Doc doc = new Doc();
    //配置service
    private DocService docService;
    private String linkId; //inboxId

    @Override
    public Doc getModel() {
        // TODO Auto-generated method stub
        return doc;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public void setDocService(DocService docService) {
        this.docService = docService;
    }

    @Test
    public void upload() {
        docService.upload(doc, linkId);
        MyUtils.outMsg("上传成功!", true);
    }


}
