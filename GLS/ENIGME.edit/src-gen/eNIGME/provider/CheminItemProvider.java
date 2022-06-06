/**
 */
package eNIGME.provider;

import eNIGME.Chemin;
import eNIGME.ENIGMEPackage;
import eNIGME.EtatChemin;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link eNIGME.Chemin} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CheminItemProvider extends JeuElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheminItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addEtatcPropertyDescriptor(object);
			addConditioncPropertyDescriptor(object);
			addEtatoPropertyDescriptor(object);
			addConditionoPropertyDescriptor(object);
			addEtatvPropertyDescriptor(object);
			addConditionvPropertyDescriptor(object);
			addPrecedentPropertyDescriptor(object);
			addSuivantPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Etatc feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEtatcPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Chemin_etatc_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Chemin_etatc_feature", "_UI_Chemin_type"),
						ENIGMEPackage.Literals.CHEMIN__ETATC, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Conditionc feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConditioncPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Chemin_conditionc_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Chemin_conditionc_feature",
								"_UI_Chemin_type"),
						ENIGMEPackage.Literals.CHEMIN__CONDITIONC, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Etato feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEtatoPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Chemin_etato_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Chemin_etato_feature", "_UI_Chemin_type"),
						ENIGMEPackage.Literals.CHEMIN__ETATO, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Conditiono feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConditionoPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Chemin_conditiono_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Chemin_conditiono_feature",
								"_UI_Chemin_type"),
						ENIGMEPackage.Literals.CHEMIN__CONDITIONO, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Etatv feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEtatvPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Chemin_etatv_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Chemin_etatv_feature", "_UI_Chemin_type"),
						ENIGMEPackage.Literals.CHEMIN__ETATV, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Conditionv feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConditionvPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Chemin_conditionv_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Chemin_conditionv_feature",
								"_UI_Chemin_type"),
						ENIGMEPackage.Literals.CHEMIN__CONDITIONV, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Precedent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrecedentPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Chemin_precedent_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Chemin_precedent_feature",
								"_UI_Chemin_type"),
						ENIGMEPackage.Literals.CHEMIN__PRECEDENT, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Suivant feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuivantPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Chemin_suivant_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Chemin_suivant_feature",
								"_UI_Chemin_type"),
						ENIGMEPackage.Literals.CHEMIN__SUIVANT, true, false, true, null, null, null));
	}

	/**
	 * This returns Chemin.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Chemin"));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		EtatChemin labelValue = ((Chemin) object).getEtatc();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ? getString("_UI_Chemin_type")
				: getString("_UI_Chemin_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Chemin.class)) {
		case ENIGMEPackage.CHEMIN__ETATC:
		case ENIGMEPackage.CHEMIN__ETATO:
		case ENIGMEPackage.CHEMIN__ETATV:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
