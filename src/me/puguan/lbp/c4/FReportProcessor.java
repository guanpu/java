package me.puguan.lbp.c4;

import java.util.Date;
import java.util.concurrent.CompletionService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Future;
/**
 *
 * @author pguan
 */
public class FReportProcessor implements Runnable{

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
    
        private boolean end;

    /**
     * Get the value of end
     *
     * @return the value of end
     */
    public boolean isEnd() {
        return end;
    }

    /**
     * Set the value of end
     *
     * @param end new value of end
     */
    public void setEnd(boolean end) {
        this.end = end;
    }

    public FReportProcessor(CompletionService service) {
        this.service = service;
        this.end = false;
    }

    @Override
    public void run() {
        while(!end) {
            try {
                //retrieve the result immediately if there's one, or at most wait for 20 seconds.
                Future<String> result = service.poll(20, TimeUnit.SECONDS);
                if(result!=null) {
                    String reportString = result.get();
                    System.out.println(reportString);
                    System.out.printf("Reporting time %d \n", new Date().getTime());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("End of Processer");
        
    }
    
}
