package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Category;

public class ItemSpec {

    private Category category;
    private boolean isPolish;
    private boolean isSecondhand;
    private boolean isHardcover;
    private boolean isMobile;
    private boolean isGuarantee;
    private boolean isVideo;

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public boolean isPolish() {
        return isPolish;
    }

    public void setPolish(boolean polish) {
        isPolish = polish;
    }

    public boolean isSecondhand() {
        return isSecondhand;
    }

    public void setSecondhand(boolean secondhand) {
        isSecondhand = secondhand;
    }

    public boolean isHardcover() {
        return isHardcover;
    }

    public void setHardcover(boolean hardcover) {
        isHardcover = hardcover;
    }

    public boolean isMobile() {
        return isMobile;
    }

    public void setMobile(boolean mobile) {
        isMobile = mobile;
    }

    public boolean isGuarantee() {
        return isGuarantee;
    }

    public void setGuarantee(boolean guarantee) {
        isGuarantee = guarantee;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }
}