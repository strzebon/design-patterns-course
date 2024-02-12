package pl.edu.agh.dronka.shop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.filter.ItemFilter;

public class PropertiesPanel extends JPanel {

	private static final long serialVersionUID = -2804446079853846996L;
	private ShopController shopController;

	private ItemFilter filter = new ItemFilter();

	public PropertiesPanel(ShopController shopController) {
		this.shopController = shopController;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	public void fillProperties() {
		removeAll();

		filter.getItemSpec().setCategory(shopController.getCurrentCategory());
		add(createPropertyCheckbox("Tanie bo polskie", event -> {
			filter.getItemSpec().setPolish(
					((JCheckBox) event.getSource()).isSelected());
			shopController.filterItems(filter);
		}));

		add(createPropertyCheckbox("Używany", event -> {
			filter.getItemSpec().setSecondhand(
					((JCheckBox) event.getSource()).isSelected());
			shopController.filterItems(filter);
		}));

		switch (shopController.getCurrentCategory()) {
			case BOOKS -> add(createPropertyCheckbox("Twarda oprawa", event -> {
				filter.getItemSpec().setHardcover(
						((JCheckBox) event.getSource()).isSelected());
				shopController.filterItems(filter);
			}));

			case ELECTRONICS -> {
				add(createPropertyCheckbox("Mobilny", event -> {
					filter.getItemSpec().setMobile(
							((JCheckBox) event.getSource()).isSelected());
					shopController.filterItems(filter);
				}));
				add(createPropertyCheckbox("Gwarancja", event -> {
					filter.getItemSpec().setGuarantee(
							((JCheckBox) event.getSource()).isSelected());
					shopController.filterItems(filter);
				}));
			}

			case MUSIC -> add(createPropertyCheckbox("Dołączone video", event -> {
				filter.getItemSpec().setVideo(
						((JCheckBox) event.getSource()).isSelected());
				shopController.filterItems(filter);
				}));
		}
	}

	private JCheckBox createPropertyCheckbox(String propertyName,
			ActionListener actionListener) {

		JCheckBox checkBox = new JCheckBox(propertyName);
		checkBox.setSelected(false);
		checkBox.addActionListener(actionListener);

		return checkBox;
	}

}
