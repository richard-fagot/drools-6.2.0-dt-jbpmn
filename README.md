# drools-6.2.0-dt-jbpmn
Exemple d'utilisation des tables de décision dans un projet Drools 6.2.0 avec ruleflow

# Comment tester le projet
Tout se passe dans *eclipse* et même s'il s'agit ici d'un projet *maven* il ne sera pas nécessaire de l'installer manuellement, il est embarqué avec *eclipse*.

1. Installer le [JDK8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) ;
2. Installer [Eclipse IDE for Java EE Developers(Mars 64bit)](http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/mars/R/eclipse-jee-mars-R-win32-x86_64.zip) ;
3. Télécharger et dézipper le plugin [*Drools 6.2.0*](http://download.jboss.org/drools/release/6.2.0.Final/droolsjbpm-tools-distribution-6.2.0.Final.zip) ;
4. Dans *Eclipse* : 
    - Help > Install new software... > Add...,
    - Name : Drools,
    - Local... > sélectionnner le répertoire org.drools.updatesite > OK > OK,
    - Sélectionner tous les plugins et installer ;
5. Cloner le projet et l'importer dans *Eclipse* en tant que projet *Maven* ;
6. Exécuter la méthoode `rfagot.examples.drools_6._dt_jbpmn.Main.main()`.
