package by.vseti.tests;

public class PhotoStep {

    PhotPage photPage = new PhotPage();

    public PhotPage loadPhoto(){
        return photPage
                .clickLoad()
                .appendAction(Actions.await(1));
    }
}
