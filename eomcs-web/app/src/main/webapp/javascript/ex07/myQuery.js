function myQuery(p) {
  let e = document.querySelector(p);

  e.val = function(v) {
    if (v == undefined) {
      return e.value;
    } else {
      e.value = v;
    }
  };

  e.on = function(eventName, listener) {
    e.addEventListener(eventName, listener);
  };

  e.click = function(listener) {
    if (listener) {
      e.on('click', listener);
    } else {
      e.dispatchEvent(new MouseEvent('click'));
    }
  };

  return e;
}

myQuery.ajax = function(p1, p2) {
  let url, settings;
  settings = {};

  if ('string' == typeof p1) {
    url = p1;
    settings = p2;
  } else {
    settings = p1;
    url = settings.url;
  }

  if (settings.method == undefined) {
    settings.method = 'get';
  }

  if (settings.dataType == undefined) {
    settings.dataType = 'text';
  }

  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = () => {
      if (xhr.readyState == 4) {
        if (xhr.status == 200) {
          if (settings.success) {
            if (settings.dataType == 'json') {
              settings.success(JSON.parse(xhr.responseText))
            } else {
              settings.success(xhr.responseText);
            }
          }
        } else {
          if (settings.error) {
            settings.error(xhr.responseText);
          }
        }
      }
  };

  let arr = [];
  if (settings.data) {
    for (let name in settings.data) {
      arr.push(name + '=' + settings.data[name])
    }
  }
  let qs = arr.join('&');

  if (settings.method == 'get') {
    xhr.open(settings.method, url + '?' + qs, true);
    xhr.send();

  } else if (settings.method == 'post') {
    xhr.open(settings.method, url, true);
    xhr.setRequestHeader(
          "Content-Type",
          "application/x-www-form-urlencoded");
    xhr.send(qs);
  }
};

myQuery.get = function(url, p1, p2, p3) {
  let settings = {
    url : url,
    method: 'get'
    dataType: 'text'
  };

  if('object' == typeof p1) {
    settings.data = p1;
    if(p2 && 'function' typeof p2) {
      setting.success = p2;
      if(p3) {
        settings.dataType = p3;
      }
    } else (p2 && 'string' == typeof p2){
      settings.dataType = p2;
    }
  } else if ('function' == typeof p1) {
    settings.success = p1;
    if(p2 && 'string' typeof p2) {
      settings.dataType = p2;
    }
  } else if ('string' == typeof p1) {
    settings.dataType = p1;
  }

  myQuery.ajax(settings);

};


let $ = myQuery;