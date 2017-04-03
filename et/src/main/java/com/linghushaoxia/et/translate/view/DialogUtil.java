package com.linghushaoxia.et.translate.view;

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
