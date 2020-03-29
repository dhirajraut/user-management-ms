package com.galaxy.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.spring.service.IService;
import com.galaxy.spring.model.UserVO;

@RestController
@RequestMapping(path = "v1/" + RestConstants.URL_USERS_BASE)
public class UserController implements IController<UserVO> {

	@Autowired
	IService<UserVO> userService;

	@RequestMapping(method = RequestMethod.GET, path = RestConstants.URL_USERS_BYID)
	@Override
	public UserVO findById(/* Variable in URL path */ @PathVariable Long id) {
		return userService.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@Override
	public Iterable<UserVO> findAll() {
		return userService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@Override
	public Iterable<UserVO> save(UserVO userVO) {
		List<UserVO> userVOList = new ArrayList<UserVO>();
		userVOList.add(userVO);
		return userService.saveAll(userVOList);
	}

	// @RequestMapping(method = RequestMethod.POST)
	// @ResponseStatus(HttpStatus.CREATED)
	// @Override
	// @TODO How to add list of new objects?
	public Iterable<UserVO> saveAll(Iterable<UserVO> userVOList) {
		return userService.saveAll(userVOList);
	}

	@RequestMapping(method = RequestMethod.PUT, path = RestConstants.URL_USERS_BYID)
	@ResponseStatus(HttpStatus.OK)
	@Override
	public Iterable<UserVO> update(/* Variable in URL Path */ @PathVariable Long id, UserVO userVO) {
		userVO.setId(id);
		List<UserVO> userVOList = new ArrayList<UserVO>();
		userVOList.add(userVO);
		return userService.saveAll(userVOList);
	}

	// @TODO How to patch the objects?
	@RequestMapping(method = RequestMethod.PATCH, path = RestConstants.URL_USERS_BYID)
	@ResponseStatus(HttpStatus.OK)
	public Iterable<UserVO> partialUpdate(/* Variable in URL Path */ @PathVariable Long id, UserVO userVO) {
		userVO.setId(id);
		List<UserVO> userVOList = new ArrayList<UserVO>();
		userVOList.add(userVO);
		return userService.saveAll(userVOList);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = RestConstants.URL_USERS_BYID)
	@Override
	public void deleteById(/* Variable in URL path */ @PathVariable Long id) {
		userService.deleteById(id);
	}


}
