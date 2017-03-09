package me.puguan.lbp.c4;

import java.util.concurrent.CompletionService;

/**
 *
 * @author pguan
 */
public class FReportRequest implements Runnable{
    
    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    private CompletionService service;

    /**
     * Get the value of service
     *
     * @return the value of service
     */
    public CompletionService getService() {
        return service;
    }

    /**
     * Set the value of service
     *
     * @param service new value of service
     */
    public void setService(CompletionService service) {
        this.service = service;
    }

    public FReportRequest(String name, CompletionService service) {
        this.name = name;
        this.service = service;
    }


    @Override
    public void run() {
        FReportGenerator generator = new FReportGenerator(name, "Report");
        service.submit(generator);
    }
    
}
