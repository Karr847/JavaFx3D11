package packt12;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

import java.util.Collection;

public class Earth extends Application {
    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Camera camera = new PerspectiveCamera(true);
        camera.setNearClip (1);
        camera.setFarClip (800);
        camera.translateZProperty ().set (-800);
        SmartGroup world = new SmartGroup ();
        world.getChildren ().add (prepareEarth ());


        Scene scene = new Scene (world, WIDTH, HEIGHT, true);
        scene.setFill (Color.SILVER);
        scene.setCamera (camera);
        primaryStage.setTitle ("Globe");
        primaryStage.setScene (scene);
        primaryStage.show ();

    }

    private Node prepareEarth() {

        PhongMaterial earthMaterial=new PhongMaterial (  );
        earthMaterial.setDiffuseMap (new Image (getClass ().getResourceAsStream ("/resources/earth.jpg")));
        Sphere sphere = new Sphere (150);
        sphere.setMaterial (earthMaterial);
        return sphere;



    }
    class SmartGroup extends Group {
        Rotate r;
        Transform t = new Rotate ( );


        void rotateByX(int ang) {
            r = new Rotate (ang, Rotate.X_AXIS);
            t = t.createConcatenation (r);
            this.getTransforms ().clear ();
            this.getTransforms ().addAll (t);
        }

        void rotateByY(int ang) {
            r = new Rotate (ang, Rotate.Y_AXIS);
            t = t.createConcatenation (r);
            this.getTransforms ().clear ();
            this.getTransforms ().addAll (t);
        }
    }

}


