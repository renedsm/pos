package com.floreantpos.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.StringUtils;

import com.floreantpos.config.TerminalConfig;
import com.floreantpos.model.base.BaseMenuGroup;

@XmlRootElement(name="menu-group")
public class MenuGroup extends BaseMenuGroup {
	private static final long serialVersionUID = 1L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public MenuGroup () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MenuGroup (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MenuGroup (
		java.lang.Integer id,
		java.lang.String name) {

		super (
			id,
			name);
	}

	/*[CONSTRUCTOR MARKER END]*/
	
	@Override
	public Integer getSortOrder() {
		return sortOrder == null ? 9999 : sortOrder;
	}
	
	@Override
	public Integer getButtonColor() {
		return buttonColor;
	}
	
	@Override
	public Integer getTextColor() {
		return textColor;
	}
	
	public String getDisplayName() {
		if(TerminalConfig.isUseTranslatedName() && StringUtils.isNotEmpty(getTranslatedName())) {
			return getTranslatedName();
		}
		
		return super.getName();
	}
	
	@Override
	public String toString() {
		return getName();
	}

	public String getUniqueId() {
		return ("menu_group_" + getName() + "_" + getId()).replaceAll("\\s+", "_"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}
}