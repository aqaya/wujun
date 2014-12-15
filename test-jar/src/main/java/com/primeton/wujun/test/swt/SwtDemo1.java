package com.primeton.wujun.test.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class SwtDemo1 {
	public static void main(String[] args) {
		// 生成Display的对象①
		Display display = new Display();
		// 生成Shell的对象②
		final Shell shell = new Shell(display);
		shell.setText("SWT的例子");
		shell.setLayout(new FillLayout(SWT.VERTICAL));
		// 生成Label对象③
		Label label = new Label(shell, SWT.BORDER);
		label.setText("请点按钮");
		// 生成Button对象③
		final Button button = new Button(shell, SWT.PUSH);
		button.setText("OK");
		// 为Button的时间定义监听器④
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				MessageBox messageBox = new MessageBox(shell, SWT.OK
						| SWT.ICON_INFORMATION | SWT.APPLICATION_MODAL);
				messageBox.setMessage("按下了（" + button.getText() + "）按钮");
				messageBox.open();
			}
		});
		// 打开shell对象 ⑤
		shell.pack();
		shell.open();
		// 结束前一直循环 ⑥
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		// 释放display对象⑦
	//	display.dispose();
	}
}
