package myp.beta;
import Formulario.AgUs;
import Formulario.Agpr;
import Formulario.ElPr;
import Formulario.ElUs;
import Formulario.Login;
import Formulario.MAg;
import Formulario.MEl;
import Formulario.Menu;

public class MYPBeta {

    public static void main(String[] args) {
        Login l = new Login();
        l.setVisible(true);
        
        Menu m = new Menu();
        m.setVisible(true);
        
        MAg ma = new MAg();
        ma.setVisible(true);
        
        AgUs ag = new AgUs();
        ag.setVisible(true);
        
        Agpr ap = new Agpr();
        ap.setVisible(true);
        
        MEl ml = new MEl();
        ml.setVisible(true);
        
        ElUs el = new ElUs();
        el.setVisible(true);
        
        ElPr ep = new ElPr();
        ep.setVisible(true);
    }
}
