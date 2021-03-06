package hudson.plugins.deploy.tomcat;

import hudson.Extension;
import hudson.plugins.deploy.ContainerAdapterDescriptor;
import org.codehaus.cargo.container.tomcat.Tomcat7xRemoteContainer;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Tomcat 7.x
 *
 * @author soudmaijer
 */
public class Tomcat7xAdapter extends TomcatAdapter {
    private static final long serialVersionUID = -7404114022873678861L;

    /**
     * Tomcat 7 support
     *
     * @param url Tomcat server location (for example: http://localhost:8080)
     * @param credentialsId the tomcat user credentials
     * @param alternativeDeploymentContext alternative context
     * @param path an alternative manager context path
     */
    @DataBoundConstructor
    public Tomcat7xAdapter(String url, String credentialsId, String alternativeDeploymentContext, String path) {
        super(url, credentialsId, alternativeDeploymentContext, path);
    }

    @Override
    public String getContainerId() {
        return Tomcat7xRemoteContainer.ID;
    }

    @Symbol("tomcat7")
    @Extension
    public static final class DescriptorImpl extends ContainerAdapterDescriptor {
        @Override
        public String getDisplayName() {
            return new Tomcat7xRemoteContainer(null).getName();
        }
    }
}
