  //-------------------Create a UserDetails--------------------------------------------------------
    
  @RequestMapping(value = "/userDetails", method = RequestMethod.POST)
  public ResponseEntity<Void> createUser(@RequestBody UserDetails userDetails,UriComponentsBuilder ucBuilder) {
      System.out.println("Creating UserDetails " + userDetails.getUserDetailsName());

      if (userDetailsDao.isUserDetailsExist(userDetails)) {
          System.out.println("A UserDetails with name " + userDetails.getUserDetailsName() + " already exist");
          return new ResponseEntity<Void>(HttpStatus.CONFLICT);
      }
      userDetails.setUserDetails_id("EVT"+UUID.randomUUID().toString().substring(30).toUpperCase());
     userDetails.setCreatedAt(new Date());
     userDetailsDao.saveOrUpdate(userDetails);

      HttpHeaders headers = new HttpHeaders();
      headers.setLocation(ucBuilder.path("/userDetails/{userDetails_id}").buildAndExpand(userDetails.getUserDetails_id()).toUri());
      return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

   