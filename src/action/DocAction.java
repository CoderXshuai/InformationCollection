package action;


import com.opensymphony.xwork2.ModelDriven;
import model.Doc;
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

    public String getDocs() {
        System.out.println(linkId);
        result = docService.getDocs(linkId);
        return "getDocs";
    }

    public String docSub() {
        try {
            String form = MyUtils.getReq().getParameter("form");
            String inboxId = MyUtils.getReq().getParameter("inboxId");
            System.out.println(form);
            File file = docService.writeJSON(form, inboxId);
            doc.setUploadFile(file);
            doc.setUploadFileContentType("json");
            doc.setUploadFileFileName(file.getName());
            doc.setUrl(file.getAbsolutePath());
            docService.upload(doc, inboxId);
            MyUtils.outMsg("上传成功!", true);
            return "docSub";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    public String delDoc() {
        try {
            String inboxId = MyUtils.getReq().getParameter("inboxId");
            System.out.println(inboxId);
            docService.del(inboxId);
            MyUtils.outMsg("删除成功!", true);
            result = null;
            return "delDoc";
        } catch (Exception e) {
            e.printStackTrace();
        }
        MyUtils.outMsg("删除失败!", false);
        return "error";
    }
}
