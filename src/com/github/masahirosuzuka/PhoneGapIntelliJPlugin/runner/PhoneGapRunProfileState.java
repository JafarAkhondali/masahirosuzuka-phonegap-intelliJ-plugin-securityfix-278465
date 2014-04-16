package com.github.masahirosuzuka.PhoneGapIntelliJPlugin.runner;

import com.github.masahirosuzuka.PhoneGapIntelliJPlugin.runner.PhoneGapRunConfiguration;
import com.github.masahirosuzuka.PhoneGapIntelliJPlugin.util.PhoneGapSettings;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.CommandLineState;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Masahiro Suzuka on 2014/04/06.
 */
public class PhoneGapRunProfileState extends CommandLineState {

  public static Project project;
  public static ExecutionEnvironment env;
  public static PhoneGapRunConfiguration phoneGapRunConfiguration;

  public PhoneGapRunProfileState(Project project,
                                 @NotNull ExecutionEnvironment env,
                                 PhoneGapRunConfiguration phoneGapRunConfiguration) {
    super(env);
    this.project = project;
    this.env = env;
    this.phoneGapRunConfiguration = phoneGapRunConfiguration;
  }

  @NotNull
  @Override
  protected ProcessHandler startProcess() throws ExecutionException {

    String projectDir = this.project.getBasePath();

    // Fix me!!
    GeneralCommandLine commandLine = new GeneralCommandLine(PhoneGapSettings.PHONEGAP_PATH,
        this.phoneGapRunConfiguration.PHONEGAP_COMMAND,
        this.phoneGapRunConfiguration.PHONEGAP_PLATFORM);

    // Change workingDir to project page
    commandLine.setWorkDirectory(projectDir);

    OSProcessHandler handler = new OSProcessHandler(commandLine);

    return handler;
  }
}
