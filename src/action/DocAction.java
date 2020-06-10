package action;


import com.opensymphony.xwork2.ModelDriven;
import model.Doc;
import org.junit.Test;
import service.DocService;
import util.MyUtils;

import java.util.List;

/**
 * @author CoderXshuai
 */
public class DocAction implements ModelDriven<Doc> {
    private final Doc doc = new Doc();
    //配置service
    private DocService docService;
    //inboxId
    private String linkId;
    private List<Doc> result;

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

    public List<Doc> getResult() {
        return result;
    }

    public void setResult(List<Doc> result) {
        this.result = result;
    }

    @Test
    public void upload() {
        docService.upload(doc, linkId);
        MyUtils.outMsg("上传成功!", true);
    }

    public String getDocs() {
        result = docService.getDocs(linkId);
        return "getDocs";
    }
}
