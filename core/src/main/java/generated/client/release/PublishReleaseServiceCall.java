// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package generated.client.release;

public class PublishReleaseServiceCall extends generated.client.core.AServiceCall {

    private String releaseId;

    public  PublishReleaseServiceCall(String releaseId) {
        this.releaseId = releaseId;
    }

    public void execute(Runnable returnHandler) {
        serviceCaller.onServiceCall(this);
        serviceCaller.getService().publishRelease(serviceCaller.getConversationNumber(), releaseId, new DefaultCallback(this, returnHandler));
    }

    @Override
    public String toString() {
        return "PublishRelease";
    }

}
