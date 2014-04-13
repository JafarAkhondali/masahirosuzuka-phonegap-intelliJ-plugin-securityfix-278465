package com.github.masahirosuzuka.PhoneGapIntelliJPlugin;

import com.intellij.openapi.module.ModuleConfigurationEditor;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.roots.ui.configuration.DefaultModuleConfigurationEditorFactory;
import com.intellij.openapi.roots.ui.configuration.ModuleConfigurationEditorProvider;
import com.intellij.openapi.roots.ui.configuration.ModuleConfigurationState;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masahiro Suzuka on 2014/04/13.
 */
public class PhoneGapModuleEditorProvider implements ModuleConfigurationEditorProvider {
  @Override
  public ModuleConfigurationEditor[] createEditors(ModuleConfigurationState state) {
    final ModuleType moduleType = ModuleType.get(state.getRootModel().getModule());

    if (!(moduleType instanceof PhoneGapModuleType)) {
      return ModuleConfigurationEditor.EMPTY;
    }

    DefaultModuleConfigurationEditorFactory defaultModuleConfigurationEditorFactory = DefaultModuleConfigurationEditorFactory.getInstance();
    List<ModuleConfigurationEditor> list = new ArrayList<>();
    list.add(defaultModuleConfigurationEditorFactory.createModuleContentRootsEditor(state));

    return list.toArray(new ModuleConfigurationEditor[list.size()]);
  }
}
