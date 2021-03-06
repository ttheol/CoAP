package com.neotys.ps.iot;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import com.google.common.base.Optional;
import com.neotys.extensions.action.Action;
import com.neotys.extensions.action.ActionParameter;
import com.neotys.extensions.action.engine.ActionEngine;

public final class CoAPRequestAction implements Action{
	private static final String BUNDLE_NAME = "com.neotys.ps.iot.bundle";
	private static final String DISPLAY_NAME = ResourceBundle.getBundle(BUNDLE_NAME, Locale.getDefault()).getString("displayName");
	private static final String DISPLAY_PATH = ResourceBundle.getBundle(BUNDLE_NAME, Locale.getDefault()).getString("displayPath");
    private static final ImageIcon DISPLAY_ICON = new ImageIcon(CoAPRequestAction.class.getResource(ResourceBundle.getBundle(BUNDLE_NAME, Locale.getDefault()).getString("iconPath")));

	@Override
	public String getType() {
		return "CoAPRequest";
	}

	@Override
	public List<ActionParameter> getDefaultActionParameters() {
		final List<ActionParameter> parameters = new ArrayList<ActionParameter>();
        parameters.add(new ActionParameter("Method", "GET"));
        parameters.add(new ActionParameter("Server", ""));
        parameters.add(new ActionParameter("Port", "5683"));
        parameters.add(new ActionParameter("Path", ""));

		return parameters;
	}

	@Override
	public Class<? extends ActionEngine> getEngineClass() {
		return CoAPRequestActionEngine.class;
	}

	@Override
	public Icon getIcon() {
		return DISPLAY_ICON;
	}

	@Override
	public boolean getDefaultIsHit(){
		return true;
	}

	@Override
	public String getDescription() {
		final StringBuilder description = new StringBuilder();
        description.append("This advanced action sends a CoAP request.\n\n");
        description.append("Possible parameters are:\n");
        description.append("  - Method (required): Method to use to send the request to the server. Possible value are GET, POST, PUT, DELETE\n");
        description.append("  - Server (required): address of the CoAP server\n");
        description.append("  - Port (required): Port of the CoAP endpoint\n");
        description.append("  - Path (optional): Path to the URI without the first /\n");
        description.append("  - Confirmable (optional): Set to true or false.\n    If true, request is confirmable. If false, request is non-confirmable.\n");
        description.append("  - Payload (optional): Send a payload along a POST or PUT request\n");
        description.append("  - Token (optional): Specifies a token for the request\n");
        description.append("  - If-None-Match (optional): Adds the If-None-Match header in a PUT request. No value needs to be specified\n");
        description.append("  - If-Match (optional): Adds an If-Match header in a PUT request. Value needs to be an hex etag without the 0x\n");
        description.append("  - Etag (optional): Adds an etag to the request. Value needs to be in hex format without the 0x\n");
        description.append("You can also add any parameter with any name and value. NeoLoad will concatenate them in the path for a GET, and in the payload for a POST or PUT.\n");
		return description.toString();
	}

	@Override
	public String getDisplayName() {
		return DISPLAY_NAME;
	}

	@Override
	public String getDisplayPath() {
		return DISPLAY_PATH;
	}

    @Override
    public Optional<String> getMinimumNeoLoadVersion() {
        return Optional.absent();
    }

    @Override
    public Optional<String> getMaximumNeoLoadVersion() {
        return Optional.absent();
    }


}
