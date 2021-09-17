package application.util;

import java.lang.reflect.Field;
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;

public class ValidationFields {

	private static final String STILE_BORDER_VALIDATION = "-fx-border-color: #FF0000";
	private static final Tooltip toolTip = new Tooltip("Este campo é obrigatório.");

	public static boolean checkEmptyFields(Node... itemToCheck) {
		// used to determinate how many fields failed in validation
		ArrayList<Node> failedFields = new ArrayList<>();
		hackTooltipStartTiming(toolTip);
		for (Node n : arrayToList(itemToCheck)) {
			// Validate TextFields
			if (n instanceof TextField) {
				TextField textField = (TextField) n;
				textField.textProperty().addListener(
						(ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
							removeToolTipAndBorderColor(textField, toolTip);
						});
				if (textField.getText() == null || textField.getText().trim().equals("")) {
					failedFields.add(n);
					addToolTipAndBorderColor(textField, toolTip);
				} else {
					removeToolTipAndBorderColor(textField, toolTip);
				}
			} // Validate Combo Box
			else if (n instanceof ComboBox) {
				ComboBox comboBox = (ComboBox) n;
				comboBox.valueProperty().addListener((ObservableValue observable, Object oldValue, Object newValue) -> {
					removeToolTipAndBorderColor(comboBox, toolTip);
				});
				if (comboBox.getValue() == null) {
					failedFields.add(n);
					addToolTipAndBorderColor(comboBox, toolTip);
				} else {
					removeToolTipAndBorderColor(comboBox, toolTip);
				}
			} // Validate TextArea
			else if (n instanceof TextArea) {
				TextArea textArea = (TextArea) n;
				textArea.textProperty().addListener(
						(ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
							removeToolTipAndBorderColor(textArea, toolTip);
						});
				if (textArea.getText() == null || textArea.getText().trim().equals("")) {
					failedFields.add(n);
					addToolTipAndBorderColor(textArea, toolTip);
				} else {
					removeToolTipAndBorderColor(textArea, toolTip);
				}
			}
			// ADD YOUR VALIDATION HERE
			// TODO
		}

		return failedFields.isEmpty();
	}

	/**
	 * *******ADD AND REMOVE STYLES********
	 */
	private static void addToolTipAndBorderColor(Node n, Tooltip t) {
		Tooltip.install(n, t);
		n.setStyle(STILE_BORDER_VALIDATION);
	}

	private static void removeToolTipAndBorderColor(Node n, Tooltip t) {
		Tooltip.uninstall(n, t);
		n.setStyle(null);
	}

	/**
	 * ***********ARRAY TO LIST UTILITY************
	 */
	private static ArrayList<Node> arrayToList(Node[] n) {
		ArrayList<Node> listItems = new ArrayList<>();
		for (Node n1 : n) {
			listItems.add(n1);
		}
		return listItems;
	}

	/**
	 * ***********FORCE TOOL TIP TO BE DISPLAYED FASTER************
	 */
	private static void hackTooltipStartTiming(Tooltip tooltip) {
		try {
			Field fieldBehavior = tooltip.getClass().getDeclaredField("BEHAVIOR");
			fieldBehavior.setAccessible(true);
			Object objBehavior = fieldBehavior.get(tooltip);

			Field fieldTimer = objBehavior.getClass().getDeclaredField("activationTimer");
			fieldTimer.setAccessible(true);
			Timeline objTimer = (Timeline) fieldTimer.get(objBehavior);

			objTimer.getKeyFrames().clear();
			objTimer.getKeyFrames().add(new KeyFrame(new Duration(5)));
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			System.out.println(e);
		}
	}
}