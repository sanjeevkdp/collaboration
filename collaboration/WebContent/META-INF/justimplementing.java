 //-------------------Create a blogComment--------------------------------------------------------
     
	  @RequestMapping(value = "/blogs/blogView", method = RequestMethod.POST)
	  public ResponseEntity<Void> createblogComment(@RequestBody ModelClass modelClass,UriComponentsBuilder ucBuilder) {
	      System.out.println("Creating blogComment " + blog);
	      System.out.println("Creating blogComment " + blogComment.getForumDescription());
	      
	     /* if (blogCommentDao.isForumExist(blogComment)) {
	          System.out.println("A blog with title " + blog.getTitle() + " already exist");
	          return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	      }*/
	      blogComment.setForumPost_id("FRMPST"+UUID.randomUUID().toString().substring(30).toUpperCase());
	      blogComment.setCreatedAt(timeStamp);
	      blogComment.setForum(modelClass.getForum());
	      blogComment.setForumDescription(modelClass.getForumPost());
	      blogComment.setUserDetails_id("USR007");
	      blogCommentDao.saveOrUpdate(blogComment);
	      HttpHeaders headers = new HttpHeaders();
	      headers.setLocation(ucBuilder.path("/blogs/{blog_id}").buildAndExpand(blog.getForum_id()).toUri());
	      return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	  }