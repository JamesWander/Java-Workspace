package view;

import controller.ProcController;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcController prc = new ProcController();
//		String os = prc.os();
//		System.out.println(os);
		
//		prc.propriedades();
//		String caminhoProcesso = "C:\\Windows\\regedit.exe";
//		prc.chamaProcesso(caminhoProcesso);
//		String caminhoProcesso = "PING -t10 www.fateczl.com.br";
//		prc.lerProcesso(caminhoProcesso);
		String processo = "notepad.exe";
		prc.mataProcesso(processo); 
	}

}
