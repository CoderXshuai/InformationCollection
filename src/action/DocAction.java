package action;


import com.opensymphony.xwork2.ModelDriven;
import model.Doc;
import org.junit.Test;
import service.DocService;
import util.MyUtils;

import java.io.File;
import java.util.List;

/**
 * @author CoderXshuai
 */
public class DocAction implements ModelDriven<Doc> {
    private final Doc doc = new Doc();
    /**
     * 配置service
     */
    private DocService docService;
    /**
     * 前端传来的inboxId
     */
    private String linkId;
    /**
     * 返回的结果
     */
    private List<Doc> result;
    private String form;
    private File file;

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

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
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

    public String docSub() {
        String form = MyUtils.getReq().getParameter("form");
        File file = docService.writeJSON(form);
        doc.setUploadFile(file);
        doc.setUploadFileContentType("json");
        doc.setUploadFileFileName(file.getName());
        doc.setName(file.getName());
        doc.setSize((file.length() / 1024 + 1) + "kb");
        doc.setUrl(file.getAbsolutePath());
        MyUtils.outMsg("上传成功!", true);
        return "docSub";
    }
}
