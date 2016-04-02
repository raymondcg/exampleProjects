package org.drools.runner.core.api;

import org.kie.api.runtime.KieContainer;

public interface KieContainerBuilder {

    public boolean createOrUpgradeRulesWithVersion( String group, String artifact, String version );

    public KieContainer getKieContainer();

    public String getCurrentVersion();

}
