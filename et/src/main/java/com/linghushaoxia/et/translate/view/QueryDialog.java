package com.linghushaoxia.et.translate.view;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import com.linghushaoxia.et.translate.Activator;
import com.linghushaoxia.et.translate.search.Search;
import com.linghushaoxia.et.translate.util.PropertiesUtil;
import com.linghushaoxia.et.translate.util.ValidateUtil;

public class QueryDialog extends Dialog{
	//查询文本框
	private Text queryText;
	//结果展示文本框
	private Text resultTextText;
	//查询按钮
	private Button queryButton;
	
    private Group infoGroup;

	protected QueryDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected Control createContents(Composite parent) {
		  Shell shell = this.getShell(); 
		  shell.setSize(400, 300);
		  Monitor primary = shell.getMonitor(); 
		  Rectangle bounds = primary.getBounds(); 
		  Rectangle rect = shell.getBounds(); 
		  int x = bounds.x + (bounds.width - rect.width) / 2; 
		  int y = bounds.y + (bounds.height - rect.height) / 2 - 50;
		  shell.setText("ET-自然语言翻译");
		  shell.setLocation (x, y);
		  shell.setImage(Activator.getImageDescriptor("/icons/menu.png").createImage());
		  /**
		   * 布局
		   */
		  Composite composite = new Composite(parent, SWT.NONE);
		  GridLayout layout = new GridLayout(3, false);
		  layout.marginBottom = 10;
		  layout.marginTop = 10;
		  layout.marginLeft = 10;
		  layout.marginRight = -30;
		  layout.horizontalSpacing = 30;
		  layout.verticalSpacing = 0;
		  composite.setLayout(layout);
		  composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		  /*headerComposite...*/
		  Composite headerComposite = new Composite(composite, SWT.NONE);
		  headerComposite.setLayout(new GridLayout(3, false));
		  headerComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		  new Label(headerComposite, SWT.NONE).setText("请输入:");
		  queryText = new Text(headerComposite, SWT.BORDER | SWT.MULTI);
		  queryText.setText(DialogUtil.getSelecedTextFromEditor());//设置选中的文字
		  queryText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		  queryButton = new Button(headerComposite, SWT.NONE);
		  queryButton.setText("查询");
		  //给Button添加事件
		  addListenerToButton();
		  //******************************//
		  //***GROUP START***//
		  Composite infoComposite = new Composite(parent, SWT.NONE);
		  infoComposite.setLayout(new GridLayout(1, true));
		  infoComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		  infoGroup = new Group(infoComposite, SWT.NONE);
		  infoGroup.setText("查询结果");
		  GridLayout groupLayout = new GridLayout(2, false);
		  groupLayout.marginBottom = 5;
		  groupLayout.marginTop = 5;
		  groupLayout.marginLeft = 10;
		  groupLayout.marginRight = 10;
		  infoGroup.setLayout(groupLayout);
		  infoGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		  infoGroup.pack();
		  resultTextText = new Text(infoGroup, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
		  resultTextText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		  String lineSeparator = "\n";
		  //以空白初始化查询结果展示框
		  StringBuilder builder = new StringBuilder();
		  int num =Integer.valueOf(PropertiesUtil.getConfigValue("init_blank_num"));
		  for(int i=0;i<num;i++){
		      builder.append(lineSeparator);
		  }
		  resultTextText.setText(builder.toString());
		  return super.createContents(parent);
	}

	@Override
	protected Button createButton(Composite parent, int id,
	        String label, boolean defaultButton) {
	    if (id == IDialogConstants.CANCEL_ID || id == IDialogConstants.OK_ID) {
	    	return null;
	    }
	    return super.createButton(parent, id, label, defaultButton);
	}
	/**
	 * 
	 * 功能说明: 添加监听事件
	 * @time:2016年12月24日下午9:24:09
	 * @author:linghushaoxia
	 * @exception:
	 *
	 */
	public void addListenerToButton(){
		queryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			    	//待查询的单词
				String qtext = queryText.getText();
				if(ValidateUtil.isBlank(qtext)){
					MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "提示", "请输入要查询的内容");
					return;
				}
				//查询
				Search search = new Search();
				resultTextText.setText(search.serachKing(qtext));
				super.mouseDown(e);
			}
		});
	}
}
