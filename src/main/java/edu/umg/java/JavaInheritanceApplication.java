package edu.umg.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import static java.lang.System.exit;

@SpringBootApplication
public class JavaInheritanceApplication extends Application {

	private final static Logger LOGGER = LoggerFactory.getLogger(JavaInheritanceApplication.class);
	private ConfigurableApplicationContext context;

	private Stage primaryStage;
	private VBox rootLayout;

	public static void main(String[] args) {
		launch(args);
	}

	public void init() throws Exception {
		LOGGER.info("Loading spring context");
		SpringApplicationBuilder builder = new SpringApplicationBuilder(JavaInheritanceApplication.class);
		context = builder.run(getParameters().getRaw().toArray(new String[0]));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			LOGGER.info("Loading Java FX context");
			ClassLoader classLoader = getClass().getClassLoader();
			FXMLLoader loader = new FXMLLoader(classLoader.getResource("fxml/main.fxml"));
			loader.setControllerFactory(context::getBean);
			rootLayout = loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setTitle("Java Inheritance Application");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			LOGGER.error("Can't load FX form: ", e);
			exit(2);
		}
	}

	@Override
	public void stop() throws Exception {
		LOGGER.info("closing application");
		context.close();
	}

}
