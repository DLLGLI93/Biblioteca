package it.corsojava.testmaven.utils;

import it.corsojava.testmaven.dto.NuovoUtenteDto;
import it.corsojava.testmaven.vo.UserVo;

public class UserUtils {
/* 
 * da vo a dto e viceversa
 */
	
	public static UserVo fromUserDtoToVo(NuovoUtenteDto dto) {
		UserVo uvo = new UserVo();
		uvo.setUsername(dto.getUsername());
		return uvo;
	}
}
