/**
 * Copyright 2016-2017 linghushaoxia
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.linghushaoxia.et.translate.util;

import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditor;
/**
 * 功能说明：对话框工具类
 * @author:linghushaoxia
 * @time:2017年4月2日下午7:22:26
 * @version:1.0
 *
 */
public class DialogUtil {
	
	public static String getSelecedTextFromEditor() {
		String selectedText = "";
		try {               
		    IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		    if ( part instanceof ITextEditor ) {
		        final ITextEditor editor = (ITextEditor)part;
		        ISelection sel = editor.getSelectionProvider().getSelection();
		        if (sel instanceof TextSelection ) {
		            TextSelection textSel = (TextSelection)sel;
		            selectedText = textSel.getText();
		        }
		    }
		} catch ( Exception ex ) {
		    ex.printStackTrace();
		}
		return selectedText;
	}

}
