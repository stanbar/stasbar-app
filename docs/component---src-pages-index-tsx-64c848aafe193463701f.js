(window.webpackJsonp=window.webpackJsonp||[]).push([[3],{"2Zxx":function(t,e,a){t.exports=a.p+"static/VapeToolLongFramed-41166ef3494a9b0a3ae050292ebbf578.webp"},"4u2T":function(t,e,a){t.exports=a.p+"static/TaxLedgerFramed-3853b80d47876ddb307cddb7c6e42a0d.png"},"6KpG":function(t,e,a){"use strict";var n=a("TqRt");e.__esModule=!0,e.default=void 0;var i=n(a("9LMJ")),M=n(a("6Wpt")),o=(n(a("7EsY")),n(a("hBwV")),function(t){return(0,i.default)((function(t,e){return!(0,M.default)(t,e)}))(t)});e.default=o},"6VHu":function(t,e,a){t.exports=a.p+"static/Wallpapers4KLongFramed-8c15a6bd730d773b1e77bbe338de85ae.png"},"6Wpt":function(t,e,a){"use strict";var n=a("TqRt");e.__esModule=!0,e.default=void 0;var i=n(a("rzV7")).default;e.default=i},"7EsY":function(t,e,a){"use strict";var n=a("TqRt");e.__esModule=!0,e.default=void 0;var i=n(a("cJVi")),M=function(t){return(0,i.default)("displayName",t)};e.default=M},"8/g6":function(t,e,a){"use strict";var n=a("TqRt");Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var i=n(a("q1tI")),M=n(a("6KpG")),o=n(a("+2mu"));var r=function(t,e){var a=function(e){return i.default.createElement(o.default,e,t)};return a.displayName="".concat(e,"Icon"),(a=(0,M.default)(a)).muiName="SvgIcon",a};e.default=r},"8n16":function(t,e,a){t.exports=a.p+"static/WallpapersOneClickLongFramed-83bf14cdf6ee39326ea41dcebf6d8abb.webp"},"9Jx+":function(t,e,a){t.exports=a.p+"static/WallpapersOneClickLongFramed-dc77aea29c0d848022ac56c7cabc6dc5.png"},"9LMJ":function(t,e,a){"use strict";var n=a("TqRt");e.__esModule=!0,e.default=void 0;var i=n(a("VbXa")),M=a("q1tI"),o=(n(a("7EsY")),n(a("hBwV")),function(t){return function(e){var a=(0,M.createFactory)(e);return function(e){function n(){return e.apply(this,arguments)||this}(0,i.default)(n,e);var M=n.prototype;return M.shouldComponentUpdate=function(e){return t(this.props,e)},M.render=function(){return a(this.props)},n}(M.Component)}});e.default=o},"CSQ+":function(t,e){t.exports="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAxMjAgMTIwIj4KICA8c3R5bGU+LnN0MHtmaWxsOiNiY2JiYmJ9LnN0MXtmaWxsOiNmNDgwMjN9PC9zdHlsZT4KICA8cGF0aCBjbGFzcz0ic3QwIiBkPSJNODQuNCA5My44VjcwLjZoNy43djMwLjlIMjIuNlY3MC42aDcuN3YyMy4yeiIvPgogIDxwYXRoIGNsYXNzPSJzdDEiCiAgICAgICAgZD0iTTM4LjggNjguNGwzNy44IDcuOSAxLjYtNy42LTM3LjgtNy45LTEuNiA3LjZ6bTUtMThsMzUgMTYuMyAzLjItNy0zNS0xNi40LTMuMiA3LjF6bTkuNy0xNy4ybDI5LjcgMjQuNyA0LjktNS45LTI5LjctMjQuNy00LjkgNS45em0xOS4yLTE4LjNsLTYuMiA0LjYgMjMgMzEgNi4yLTQuNi0yMy0zMXpNMzggODZoMzguNnYtNy43SDM4Vjg2eiIvPgo8L3N2Zz4K"},DERd:function(t,e,a){t.exports=a.p+"static/TaxLedgerFramed-98a1d6021fc10be5a56bc850a215125c.webp"},JV3m:function(t,e,a){t.exports=a.p+"static/VapeToolLongFramed-8e23a94dedc0ee03a30e8a833ec1bc79.png"},Kfvu:function(t,e,a){"use strict";var n=a("TqRt");e.__esModule=!0,e.OutboundLink=c,e.trackCustomEvent=function(t){var e=t.category,a=t.action,n=t.label,i=t.value,M=t.nonInteraction,o=void 0===M||M,c=t.transport,g=t.hitCallback,u=t.callbackTimeout,s=void 0===u?1e3:u;if("undefined"!=typeof window&&window.ga){var l={eventCategory:e,eventAction:a,eventLabel:n,eventValue:i,nonInteraction:o,transport:c};g&&"function"==typeof g&&(l.hitCallback=r(g,s)),window.ga("send","event",l)}};var i=n(a("pVnL")),M=n(a("q1tI")),o=n(a("17x9")),r=function(t,e){void 0===e&&(e=1e3);var a=!1,n=function(){a||(a=!0,t())};return setTimeout(n,e),n};function c(t){return M.default.createElement("a",(0,i.default)({},t,{onClick:function(e){"function"==typeof t.onClick&&t.onClick(e);var a=!0;return(0!==e.button||e.altKey||e.ctrlKey||e.metaKey||e.shiftKey||e.defaultPrevented)&&(a=!1),t.target&&"_self"!==t.target.toLowerCase()&&(a=!1),window.ga?window.ga("send","event",{eventCategory:"Outbound Link",eventAction:"click",eventLabel:t.href,transport:a?"beacon":"",hitCallback:function(){a&&(document.location=t.href)}}):a&&(document.location=t.href),!1}}))}c.propTypes={href:o.default.string,target:o.default.string,onClick:o.default.func}},"L/qg":function(t,e,a){"use strict";var n=a("TqRt");Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var i=n(a("q1tI")),M=(0,n(a("8/g6")).default)(i.default.createElement(i.default.Fragment,null,i.default.createElement("path",{d:"M6 17h3l2-4V7H5v6h3zm8 0h3l2-4V7h-6v6h3z"}),i.default.createElement("path",{fill:"none",d:"M0 0h24v24H0z"})),"FormatQuote");e.default=M},QeBL:function(t,e,a){"use strict";a.r(e);var n=a("SUMQ"),i=a("q1tI"),M=a.n(i),o=a("DvoB");var r=function(t){var e,a;function n(){return t.apply(this,arguments)||this}return a=t,(e=n).prototype=Object.create(a.prototype),e.prototype.constructor=e,e.__proto__=a,n.prototype.render=function(){var t=this.props.classes;return i.createElement("div",{className:t.heroContent},i.createElement(o.i,{variant:"h6",align:"center",color:"textSecondary",paragraph:!0},"Motivated by the newest technologies and business opportunities. Currently focusing on blockchain technology. Key values in my life:",i.createElement("br",null),"Efficiency🏍️, Development🚀, Adaptation🦎, Freedom🌎 and Simplicity🍎"))},n}(i.Component),c=Object(n.withStyles)((function(t){return Object(n.createStyles)({heroContent:{maxWidth:700,margin:"0 auto",padding:8*t.spacing.unit+"px 0 "+6*t.spacing.unit+"px"}})}))(r);function g(t){return i.createElement(o.g,t,i.createElement("path",{fill:"#006CAC",d:"M19,3A2,2 0 0,1 21,5V19A2,2 0 0,1 19,21H5A2,2 0 0,1 3,19V5A2,2 0 0,1 5,3H19M18.5,18.5V13.2A3.26,3.26 0 0,0 15.24,9.94C14.39,9.94 13.4,10.46 12.92,11.24V10.13H10.13V18.5H12.92V13.57C12.92,12.8 13.54,12.17 14.31,12.17A1.4,1.4 0 0,1 15.71,13.57V18.5H18.5M6.88,8.56A1.68,1.68 0 0,0 8.56,6.88C8.56,5.95 7.81,5.19 6.88,5.19A1.69,1.69 0 0,0 5.19,6.88C5.19,7.81 5.95,8.56 6.88,8.56M8.27,18.5V10.13H5.5V18.5H8.27Z"}))}function u(t){return i.createElement(o.g,t,i.createElement("path",{d:"M12,2A10,10 0 0,0 2,12C2,16.42 4.87,20.17 8.84,21.5C9.34,21.58 9.5,21.27 9.5,21C9.5,20.77 9.5,20.14 9.5,19.31C6.73,19.91 6.14,17.97 6.14,17.97C5.68,16.81 5.03,16.5 5.03,16.5C4.12,15.88 5.1,15.9 5.1,15.9C6.1,15.97 6.63,16.93 6.63,16.93C7.5,18.45 8.97,18 9.54,17.76C9.63,17.11 9.89,16.67 10.17,16.42C7.95,16.17 5.62,15.31 5.62,11.5C5.62,10.39 6,9.5 6.65,8.79C6.55,8.54 6.2,7.5 6.75,6.15C6.75,6.15 7.59,5.88 9.5,7.17C10.29,6.95 11.15,6.84 12,6.84C12.85,6.84 13.71,6.95 14.5,7.17C16.41,5.88 17.25,6.15 17.25,6.15C17.8,7.5 17.45,8.54 17.35,8.79C18,9.5 18.38,10.39 18.38,11.5C18.38,15.32 16.04,16.16 13.81,16.41C14.17,16.72 14.5,17.33 14.5,18.26C14.5,19.6 14.5,20.68 14.5,21C14.5,21.27 14.66,21.59 15.17,21.5C19.14,20.16 22,16.42 22,12A10,10 0 0,0 12,2Z"}))}var s=a("hxE/"),l=a("CSQ+"),I=a("efvk"),N=a("tv6k"),j=a("Kfvu").OutboundLink,L=function(t){var e,a;function n(){return t.apply(this,arguments)||this}return a=t,(e=n).prototype=Object.create(a.prototype),e.prototype.constructor=e,e.__proto__=a,n.prototype.render=function(){var t=this.props.classes;var e=function(e){return i.createElement(o.d,{item:!0,className:t.intentButton},i.createElement(j,{href:e.href,label:e.name,target:"_blank",style:{textDecoration:"none"}},i.createElement(o.b,{variant:"contained",color:"primary",style:{color:e.textColor,backgroundColor:e.backgroundColor}},e.Icon,e.name)))};return i.createElement("div",{className:t.content},i.createElement(o.i,{variant:"h1",align:"center",gutterBottom:!0,className:t.nameTitle},"STANISLAW BARANSKI"),i.createElement(o.i,{variant:"h6",align:"center",gutterBottom:!0},i.createElement("u",{className:t.keyword},"full stack android developer"),",  ",i.createElement("u",{className:t.keyword},"beginner entrepreneur"),",  ",i.createElement("u",{className:t.keyword},"blockchain enthusiast"),",  ",i.createElement("u",{className:t.keyword},"b.eng. computer science"),",  ",i.createElement("u",{className:t.keyword},(new Date).getUTCFullYear()-1995," years old")),i.createElement(o.d,{container:!0,spacing:0,justify:"center",className:t.buttons},i.createElement(e,{name:"LinkedIn",href:"https://www.linkedin.com/in/stasbar/",Icon:i.createElement(g,null),textColor:"#243641",backgroundColor:"#FFF"}),i.createElement(e,{name:"Github",href:"https://github.com/stasbar",Icon:i.createElement(u,null),textColor:"#FFF",backgroundColor:"#212529"}),i.createElement(e,{name:"Keybase",href:"https://keybase.io/stasbar",Icon:i.createElement("img",{src:s,width:20}),textColor:"#FFF",backgroundColor:"#3095F4"}),i.createElement(e,{name:"StackOverflow",href:"https://stackoverflow.com/story/stasbar",Icon:i.createElement("img",{src:l,width:20}),textColor:"#343536",backgroundColor:"#F9F9FA"}),i.createElement(e,{name:"TaxLedger",href:"https://tax-ledger.com",Icon:i.createElement("img",{src:N,width:20}),textColor:"#243641",backgroundColor:"#FFF"}),i.createElement(e,{name:"VapeTool",href:"https://vapetool.app",Icon:i.createElement("img",{src:I,width:20}),textColor:"#FFF",backgroundColor:"#3546A7"})),i.createElement(o.d,{container:!0,spacing:0,justify:"center",className:t.specs},i.createElement(o.d,{item:!0,xs:6,sm:6,md:3,lg:3,className:t.specGridItem},i.createElement(o.i,{className:t.specName},"Android"),i.createElement(o.i,{component:"p",color:"textSecondary",className:t.specDesc},"My main specialty is mobile applications for Android in Java and Kotlin.")),i.createElement(o.d,{item:!0,xs:6,sm:6,md:3,lg:3,className:t.specGridItem},i.createElement(o.i,{className:t.specName},"Backend"),i.createElement(o.i,{component:"p",color:"textSecondary",className:t.specDesc},"I chose Firebase whenever possible. Kotlin with ktor, Typescript with Nodejs, and Python for scripting.")),i.createElement(o.d,{item:!0,xs:6,sm:6,md:3,lg:3,className:t.specGridItem},i.createElement(o.i,{className:t.specName},"Frontend"),i.createElement(o.i,{component:"p",color:"textSecondary",className:t.specDesc},"My favorite framework is React/TS. Concept of components composition combined with JSX seduced me.")),i.createElement(o.d,{item:!0,xs:6,sm:6,md:3,lg:3,className:t.specGridItem},i.createElement(o.i,{className:t.specName},"Tools"),i.createElement(o.i,{component:"p",color:"textSecondary",className:t.specDesc},"When it comes to tools, I love IntelliJ/AS and Vim running on macOS."))))},n}(i.Component),y=Object(n.withStyles)((function(t){return Object(n.createStyles)({nameTitle:{fontSize:"2rem",fontWeight:600,marginBottom:"1rem",color:t.palette.text.primary},content:{maxWidth:600,margin:"0 auto",padding:8*t.spacing.unit+"px 0 "+6*t.spacing.unit+"px"},buttons:{marginTop:4*t.spacing.unit},intentButton:{margin:t.spacing.unit},specs:{marginTop:4*t.spacing.unit},keyword:{color:t.palette.secondary.main,borderBottom:".1rem solid currentColor",textDecoration:"none",textOverflow:"ellipsis",whiteSpace:"nowrap"},specGridItem:{background:"inherit",padding:t.spacing.unit},specName:{color:t.palette.secondary.main,margin:t.spacing.unit,fontSize:"1rem",fontWeight:700,textAlign:"center"},specDesc:{align:"justify"}})}))(L);a("y7hu");var p=function(t){var e,a;function n(){return t.apply(this,arguments)||this}return a=t,(e=n).prototype=Object.create(a.prototype),e.prototype.constructor=e,e.__proto__=a,n.prototype.render=function(){var t=this.props,e=t.app,a=t.classes,n=function(t){return i.createElement("a",{className:a.link,href:t.href},t.text)};return i.createElement(o.d,{item:!0,sm:"mobile"===e.platform?3:6,md:"mobile"===e.platform?3:6,lg:"mobile"===e.platform?3:6,className:a.root},i.createElement(o.i,{variant:"h4",color:"secondary",className:a.name},e.name),i.createElement("picture",null,i.createElement("source",{srcSet:e.imgSrc,type:"image/png",className:a.img}),i.createElement("source",{srcSet:e.imgWebp,type:"image/webp",className:a.img}),i.createElement("img",{src:e.imgSrc,alt:e.name,className:a.img})),i.createElement(o.i,{className:a.description},e.description,e.links.googlePlay&&e.links.appStore&&". Both on ",e.links.googlePlay&&e.links.appStore&&i.createElement(n,{href:e.links.googlePlay,text:"Android"}),e.links.googlePlay&&e.links.appStore&&" and ",e.links.googlePlay&&e.links.appStore&&i.createElement(n,{href:e.links.appStore,text:"iOS"}),e.links.googlePlay&&!e.links.appStore&&". Check out on ",e.links.googlePlay&&!e.links.appStore&&i.createElement(n,{href:e.links.googlePlay,text:"Google Play"}),e.links.github&&". Check it out on ",e.links.github&&i.createElement(n,{href:e.links.github,text:"Github"}),e.links.website&&". See ",e.links.website&&i.createElement(n,{href:e.links.website,text:"website"})))},n}(i.Component),m=Object(n.withStyles)((function(t){return Object(n.createStyles)({root:{display:"flex",alignSelf:"flex-start",flexDirection:"column",justifyItems:"center",alignItems:"center",textDecoration:"none"},name:{marginBottom:t.spacing.unit,fontSize:"1rem",fontWeight:700},img:{height:"auto",width:"100%"},description:{textAlign:"justify",textDecoration:"none",color:t.palette.text.secondary,fontSize:"1rem"},link:{textDecoration:"none",borderBottom:".1rem solid currentColor",paddingBottom:"0.05rem",color:t.palette.text.primary,"&:hover":{color:t.palette.secondary.main}}})}))(p);var A=function(t){var e,a;function n(){return t.apply(this,arguments)||this}return a=t,(e=n).prototype=Object.create(a.prototype),e.prototype.constructor=e,e.__proto__=a,n.prototype.render=function(){var t=this.props.classes;return i.createElement("div",{className:t.root},i.createElement(o.i,{variant:"h2",align:"center",color:"textPrimary",gutterBottom:!0,className:t.nameTitle},this.props.title),i.createElement("div",{className:t.layout},i.createElement(o.d,{container:!0,justify:"center",spacing:40,style:{alignContent:"flex-start",alignItems:"stretch",flexGrow:1}},this.props.apps.map((function(t){return i.createElement(m,{key:t.name,app:t})})))))},n}(i.Component),D=Object(n.withStyles)((function(t){var e;return Object(n.createStyles)({root:{margin:"0 auto",padding:8*t.spacing.unit+"px 0 "+6*t.spacing.unit+"px"},nameTitle:{fontWeight:500,fontSize:"2rem"},layout:(e={width:"auto",marginLeft:3*t.spacing.unit,marginRight:3*t.spacing.unit,padding:8*t.spacing.unit+"px 0"},e[t.breakpoints.up(800+3*t.spacing.unit*2)]={width:800,marginLeft:"auto",marginRight:"auto"},e.display="flex",e.flexWrap="wrap",e.flexGrow=1,e.flexDirection="column",e.justifyContent="space-around",e.overflow="hidden",e)})}))(A),C=a("o0o1"),T=a.n(C),d=(a("ls82"),a("E5k/"),a("Wbzz")),z=a("axFy"),x=a("qorR"),S=a.n(x);var w=function(t){var e,a;function n(){for(var e,a=arguments.length,n=new Array(a),i=0;i<a;i++)n[i]=arguments[i];return(e=t.call.apply(t,[this].concat(n))||this).state={books:new Array,loading:!0},e}a=t,(e=n).prototype=Object.create(a.prototype),e.prototype.constructor=e,e.__proto__=a;var i=n.prototype;return i.componentDidMount=function(){this.fetchBooks()},i.render=function(){var t=this.props.classes,e=this.state,a=e.books,n=e.loading;return M.a.createElement("div",{className:t.root},M.a.createElement(o.i,{variant:"h2",align:"center",color:"textPrimary",gutterBottom:!0,className:t.nameTitle},"My favorite books"),M.a.createElement("div",{className:t.layout},M.a.createElement(o.d,{container:!0,spacing:40,justify:"center"},n&&M.a.createElement(o.d,{item:!0,sm:12},M.a.createElement(o.i,{variant:"h5"},"Loading...")),a.map((function(e){return M.a.createElement(o.d,{key:e.hash,item:!0,xs:6,sm:3,md:2,lg:2,style:{height:"auto",width:"100%"}},M.a.createElement(o.e,null,M.a.createElement("img",{src:e.imageUrl,alt:e.title,className:t.img}),M.a.createElement(o.f,{title:e.title,subtitle:M.a.createElement("span",null,"by: ",e.author)})))}))),M.a.createElement(o.b,{className:t.moreBooksButton,variant:"outlined",component:function(t){return M.a.createElement(d.a,Object.assign({},t,{to:"/books"}))},color:"secondary"},"Books",M.a.createElement(S.a,{className:t.rightIcon}))))},i.fetchBooks=function(){var t;return T.a.async((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,T.a.awrap(z.a.fetchFeaturedBooks());case 3:t=e.sent,this.setState({books:t,loading:!1}),e.next=11;break;case 7:e.prev=7,e.t0=e.catch(0),console.error(e.t0),this.setState({loading:!1});case 11:case"end":return e.stop()}}),null,this,[[0,7]])},n}(i.Component),E=Object(n.withStyles)((function(t){var e;return Object(n.createStyles)({root:{margin:"0 auto",padding:8*t.spacing.unit+"px 0 "+6*t.spacing.unit+"px"},layout:(e={width:"auto",marginLeft:3*t.spacing.unit,marginRight:3*t.spacing.unit},e[t.breakpoints.up(1100+3*t.spacing.unit*2)]={width:1100,marginLeft:"auto",marginRight:"auto"},e.display="flex",e.flexWrap="wrap",e.flexGrow=1,e.flexDirection="column",e.justifyContent="space-around",e.overflow="hidden",e.padding=8*t.spacing.unit+"px 0",e),img:{width:"100%",height:"auto"},nameTitle:{fontWeight:500,fontSize:"2rem"},moreBooksButton:{width:"auto",alignSelf:"center",marginTop:50,marginLeft:-12,marginRight:20},rightIcon:{marginLeft:t.spacing.unit}})}))(w),O=a("L/qg"),f=a.n(O);var b=function(t){var e,a;function n(){for(var e,a=arguments.length,n=new Array(a),i=0;i<a;i++)n[i]=arguments[i];return(e=t.call.apply(t,[this].concat(n))||this).state={quotes:new Array,loading:!0},e}a=t,(e=n).prototype=Object.create(a.prototype),e.prototype.constructor=e,e.__proto__=a;var i=n.prototype;return i.componentDidMount=function(){this.fetchQuotes()},i.render=function(){var t=this.props.classes,e=this.state,a=e.quotes,n=e.loading;return M.a.createElement("div",{className:t.root},M.a.createElement(o.i,{variant:"h2",align:"center",color:"textPrimary",gutterBottom:!0,className:t.nameTitle},"My favorite quotes"),M.a.createElement("div",{className:t.layout},n&&M.a.createElement(o.d,{item:!0,sm:12},M.a.createElement(o.i,{variant:"h5"},"Loading...")),a.map((function(e){return M.a.createElement(o.c,{key:e.hash,className:t.cardQuote},M.a.createElement(o.i,{variant:"body1"},M.a.createElement("i",null,e.text)," ~",e.author))})),M.a.createElement(o.b,{className:t.moreQuotesButton,variant:"outlined",component:function(t){return M.a.createElement(d.a,Object.assign({},t,{to:"/quotes"}))},color:"secondary"},"Quotes",M.a.createElement(f.a,{className:t.rightIcon}))))},i.fetchQuotes=function(){var t;return T.a.async((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,T.a.awrap(z.a.fetchFeaturedQuotes());case 3:t=e.sent,this.setState({quotes:t,loading:!1}),e.next=11;break;case 7:e.prev=7,e.t0=e.catch(0),console.error(e.t0),this.setState({loading:!1});case 11:case"end":return e.stop()}}),null,this,[[0,7]])},n}(i.Component),k=Object(n.withStyles)((function(t){var e;return Object(n.createStyles)({root:{margin:"0 auto",padding:8*t.spacing.unit+"px 0 "+6*t.spacing.unit+"px"},layout:(e={width:"auto",marginLeft:3*t.spacing.unit,marginRight:3*t.spacing.unit},e[t.breakpoints.up(1100+3*t.spacing.unit*2)]={width:1100,marginLeft:"auto",marginRight:"auto"},e.display="flex",e.flexWrap="wrap",e.flexGrow=1,e.flexDirection="column",e.justifyContent="space-around",e.overflow="hidden",e.padding=8*t.spacing.unit+"px 0",e),cardQuote:{backgroundColor:t.palette.primary.light,textDecoration:"none",margin:t.spacing.unit+"px 0",padding:t.spacing.unit+"px"},nameTitle:{fontWeight:500,fontSize:"2rem"},moreQuotesButton:{width:"auto",alignSelf:"center",marginTop:50,marginLeft:-12,marginRight:20},rightIcon:{marginLeft:t.spacing.unit}})}))(b),h=a("JV3m"),Y=a.n(h),v=a("uVIg"),Q=a.n(v),U=a("6VHu"),P=a.n(U),G=a("9Jx+"),Z=a.n(G),W=a("pf18"),B=a.n(W),F=a("4u2T"),R=a.n(F),H=a("2Zxx"),J=a.n(H),K=a("u5Ab"),_=a.n(K),V=a("UrXU"),X=a.n(V),q=a("8n16"),$=a.n(q),tt=a("T/T5"),et=a.n(tt),at=a("DERd"),nt=a.n(at),it=[{name:"Vape Tool",imgSrc:Y.a,imgWebp:J.a,description:"Fully fledged utility arsenal and social media for Vapers. Over 1M downloads and 300k active users",platform:"mobile",links:{website:"https://vapetool.stasbar.com",github:null,googlePlay:"https://play.google.com/store/apps/details?id=com.stasbar.vape_tool",appStore:"https://itunes.apple.com/us/app/coil-builder/id1210289983?mt=8"}},{name:"Tax Ledger",imgSrc:R.a,imgWebp:nt.a,description:"Desktop application for settle taxes from cryptocurrencies exchanges",platform:"desktop",links:{website:"https://tax-ledger.com",github:null,googlePlay:null,appStore:null}},{name:"4K Wallpapers",imgSrc:P.a,imgWebp:X.a,description:"High resolution wallpapers",platform:"mobile",links:{website:null,github:null,googlePlay:"https://play.google.com/store/apps/details?id=com.wallpapers.new_wallpapers4k",appStore:null}},{name:"Go Lure",imgSrc:Q.a,imgWebp:_.a,description:"Catching the Pokemon Go hype, with addon scheduler for lure module party on a map",platform:"mobile",links:{website:null,github:null,googlePlay:"https://play.google.com/store/apps/details?id=com.stasbar.golure",appStore:null}},{name:"Easy Wallpapers",imgSrc:Z.a,imgWebp:$.a,description:"Easy to use wallpaper apps build with many category flavors",platform:"mobile",links:{website:null,github:null,googlePlay:"https://play.google.com/store/apps/details?id=com.david_wallpapers.city_night",appStore:null}},{name:"Wishes",imgSrc:B.a,imgWebp:et.a,description:"Wishes application for many occasion flavors",platform:"mobile",links:{website:null,github:null,googlePlay:"https://play.google.com/store/apps/details?id=com.allwishes.christmas",appStore:null}}],Mt=[{name:"Raspberry Wallet",imgSrc:a("mCuS"),imgWebp:a("T88I"),description:"Bitcoin hardware wallet on Raspberry Pi Zero",platform:"desktop",links:{website:"https://raspberrywallet.github.io/readme.html",github:"https://github.com/RaspberryWallet",googlePlay:null,appStore:null}},{name:"stasbar.com",imgSrc:a("ccOm"),imgWebp:a("akr9"),description:"This website & android app itself is my pet-project, so I think it's worth mention here",platform:"desktop",links:{website:null,github:"https://github.com/stasbar/stasbar-app",googlePlay:null,appStore:null}}];var ot=function(t){var e,a;function n(){return t.apply(this,arguments)||this}return a=t,(e=n).prototype=Object.create(a.prototype),e.prototype.constructor=e,e.__proto__=a,n.prototype.render=function(){var t=this.props.classes;return i.createElement("div",null,i.createElement("div",{className:t.odd},i.createElement(y,null)),i.createElement("div",{className:t.even},i.createElement(c,null)),i.createElement("div",{className:t.odd},i.createElement(D,{title:"My Apps",apps:it})),i.createElement("div",{className:t.even},i.createElement(D,{title:"Other Projects",apps:Mt})),i.createElement("div",{className:t.odd},i.createElement(E,null)),i.createElement("div",{className:t.even},i.createElement(k,null)))},n}(i.Component);e.default=Object(n.withStyles)((function(t){return Object(n.createStyles)({odd:{backgroundColor:t.palette.primary.light},even:{backgroundColor:t.palette.primary.main}})}))(ot)},"T/T5":function(t,e,a){t.exports=a.p+"static/WishesLongFramed-16c18fde65a7b18af8441aab47ec71ce.webp"},T88I:function(t,e,a){t.exports=a.p+"static/RaspberryWalletFramed-b2a1bcf16af389b01ee88c180cbaa624.webp"},UrXU:function(t,e,a){t.exports=a.p+"static/Wallpapers4KLongFramed-843ab7e0b15a4c527b8a77582cbbc387.webp"},akr9:function(t,e,a){t.exports=a.p+"static/WebsiteFramed-7628754260accff8d414e9e0aa3a397e.webp"},cFM1:function(t,e,a){"use strict";e.__esModule=!0,e.default=void 0;var n=function(t){return"string"==typeof t?t:t?t.displayName||t.name||"Component":void 0};e.default=n},cJVi:function(t,e,a){"use strict";e.__esModule=!0,e.default=void 0;var n=function(t,e){return function(a){return a[t]=e,a}};e.default=n},ccOm:function(t,e,a){t.exports=a.p+"static/WebsiteFramed-8668a4c04143243484e42501e6465fde.png"},efvk:function(t,e){t.exports="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMTAwJSIgaGVpZ2h0PSIxMDAlIiB2aWV3Qm94PSIwIDAgNTEyIDUxMiIgdmVyc2lvbj0iMS4xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciCiAgICAgeG1sOnNwYWNlPSJwcmVzZXJ2ZSIKICAgICBzdHlsZT0iZmlsbC1ydWxlOmV2ZW5vZGQ7Y2xpcC1ydWxlOmV2ZW5vZGQ7c3Ryb2tlLWxpbmVjYXA6cm91bmQ7c3Ryb2tlLWxpbmVqb2luOnJvdW5kO3N0cm9rZS1taXRlcmxpbWl0OjEuNTsiPgogICAgPGNpcmNsZSBjeD0iMjU2LjU3OCIgY3k9IjI1NiIgcj0iMjUyLjIzNSIgc3R5bGU9ImZpbGw6cmdiKDYzLDgxLDE4MSk7Ii8+CiAgPGNsaXBQYXRoIGlkPSJfY2xpcDEiPgogICAgICAgIDxjaXJjbGUgY3g9IjI1Ni41NzgiIGN5PSIyNTYiIHI9IjI1Mi4yMzUiLz4KICAgIDwvY2xpcFBhdGg+CiAgPGcgY2xpcC1wYXRoPSJ1cmwoI19jbGlwMSkiPgogICAgICAgIDxnIHRyYW5zZm9ybT0ibWF0cml4KDEuMzk1ODEsMCwwLDEuMzk1ODEsLTk2LjY4NjYsLTk1LjY1NzkpIj4KICAgICAgICAgICAgPHBhdGggZD0iTTM2NC41MDksMTY4LjYwOUw1NjcuOSwzNzJMNTY3LDUzOEwtMTMsNTMyTDE1MywyMDNDMTUzLDIwMyAyMzUuMDYyLDEwNy4xODEgMzY0LjUwOSwxNjguNjA5WiIKICAgICAgICAgICAgICAgICAgc3R5bGU9ImZpbGw6cmdiKDUwLDY1LDE0NSk7Ii8+CiAgICAgICAgICA8ZyB0cmFuc2Zvcm09Im1hdHJpeCgtMC45NTQ3NTUsLTAuNTA3NjUyLC0wLjY5NDU4MywxLjMwNjMyLDY3OC43MzIsNjEuNDA5MikiPgogICAgICAgICAgICAgICAgPHBhdGggZD0iTTM1NS42MzIsMjQzLjUxMUwzNTUuNzgzLDQ4My4xOTNMMzU4LjU4Myw0ODQuMjgxTDM4NC45ODksNDQ3Ljk4NEwzODQuOTQ5LDIzOC43NDgiCiAgICAgICAgICAgICAgICAgICAgICBzdHlsZT0iZmlsbDp3aGl0ZTsiLz4KICAgICAgICAgICAgPC9nPgogICAgICAgICAgPGc+CiAgICAgICAgICAgICAgICA8cGF0aAogICAgICAgICAgICAgICAgICBkPSJNMjY3LjYzNiwzMTYuMDYxQzI1My4xMjksMzMxLjYwNyAyMzQuMywzNDEgMjEzLjczNCwzNDFDMTY3LjkyNSwzNDEgMTMwLjczNCwyOTQuMzk5IDEzMC43MzQsMjM3QzEzMC43MzQsMTc5LjYwMSAxNjcuOTI1LDEzMyAyMTMuNzM0LDEzM0MyMzYuNTg5LDEzMyAyNTcuMjk4LDE0NC42IDI3Mi4zMTQsMTYzLjM1M0MyNDIuNDgsMTcyLjE1NCAyMjAuMzk4LDIwMy4zNzcgMjIwLjM5OCwyNDAuNUMyMjAuMzk4LDI3NS42NTQgMjQwLjIsMzA1LjUxOSAyNjcuNjM2LDMxNi4wNjFaIgogICAgICAgICAgICAgICAgICBzdHlsZT0iZmlsbDp3aGl0ZTtzdHJva2U6cmdiKDU0LDY0LDE1Nyk7c3Ryb2tlLXdpZHRoOjEuNDNweDsiLz4KICAgICAgICAgICAgPHBhdGgKICAgICAgICAgICAgICBkPSJNMjk1LjQyLDMxNy44ODNDMjgxLjE2NCwzMzIuMzM4IDI2My4wMTYsMzQxIDI0My4yNjYsMzQxQzE5Ny40NTgsMzQxIDE2MC4yNjYsMjk0LjM5OSAxNjAuMjY2LDIzN0MxNjAuMjY2LDE3OS42MDEgMTk3LjQ1OCwxMzMgMjQzLjI2NiwxMzNDMjYzLjAxNiwxMzMgMjgxLjE2NCwxNDEuNjYyIDI5NS40MiwxNTYuMTE3QzI2MC4zNDYsMTYzLjI3IDIzMy43NywxOTYuNzg2IDIzMy43NywyMzdDMjMzLjc3LDI3Ny4yMTQgMjYwLjM0NiwzMTAuNzMgMjk1LjQyLDMxNy44ODNaIgogICAgICAgICAgICAgIHN0eWxlPSJmaWxsOndoaXRlO3N0cm9rZTpyZ2IoNTQsNjQsMTU3KTtzdHJva2Utd2lkdGg6MS40M3B4OyIvPgogICAgICAgICAgICA8ZyB0cmFuc2Zvcm09Im1hdHJpeCgxLDAsMCwxLjAxOTYxLC0yOS4yMDA4LC0yLjYwNzg0KSI+CiAgICAgICAgICAgICAgICAgICAgPHBhdGgKICAgICAgICAgICAgICAgICAgICAgIGQ9Ik0zMDIsMTMzQzMxNC41MzEsMTMzIDMyNi40MTgsMTM2LjQyIDMzNy4wNzUsMTQyLjU0MkMzNDkuMzEsMTQ5LjU3MSAyODUuMjAxLDE2Ni4yMzQgMjg1LjIwMSwxNjYuMjM0TDI2NywyMzYuNDcxTDI5NS45NiwzMDYuODI5QzI5NS45NiwzMDYuODI5IDM0NS45MzQsMzIyLjY5MyAzMzUuMzc5LDMyOC40MDNDMzI1LjE2MywzMzMuOTMxIDMxMy44NzEsMzM3IDMwMiwzMzdDMjU2LjE5MSwzMzcgMjE5LDI5MS4yOTUgMjE5LDIzNUMyMTksMTc4LjcwNSAyNTYuMTkxLDEzMyAzMDIsMTMzWiIKICAgICAgICAgICAgICAgICAgICAgIHN0eWxlPSJmaWxsOndoaXRlO3N0cm9rZTpyZ2IoNTQsNjQsMTU3KTtzdHJva2Utd2lkdGg6MS40MnB4OyIvPgogICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICA8cGF0aAogICAgICAgICAgICAgIGQ9Ik0zMDIsMTMzQzM0Ny44MDksMTMzIDM4NSwxNzkuNjAxIDM4NSwyMzdDMzg1LDI5NC4zOTkgMzQ3LjgwOSwzNDEgMzAyLDM0MUMyNTYuMTkxLDM0MSAyMTksMjk0LjM5OSAyMTksMjM3QzIxOSwxNzkuNjAxIDI1Ni4xOTEsMTMzIDMwMiwxMzNaTTMwMiwxNzIuNTg5QzMzMS4zMzUsMTcyLjU4OSAzNTUuMTUxLDIwMi4xMjMgMzU1LjE1MSwyMzguNUMzNTUuMTUxLDI3NC44NzcgMzMxLjMzNSwzMDQuNDExIDMwMiwzMDQuNDExQzI3Mi42NjUsMzA0LjQxMSAyNDguODQ5LDI3NC44NzcgMjQ4Ljg0OSwyMzguNUMyNDguODQ5LDIwMi4xMjMgMjcyLjY2NSwxNzIuNTg5IDMwMiwxNzIuNTg5WiIKICAgICAgICAgICAgICBzdHlsZT0iZmlsbDp3aGl0ZTtzdHJva2U6cmdiKDU0LDY0LDE1Nyk7c3Ryb2tlLXdpZHRoOjEuNDNweDsiLz4KICAgICAgICAgICAgPC9nPgogICAgICAgICAgPGcgdHJhbnNmb3JtPSJtYXRyaXgoMS4wMTE1MywtMC41Mzc4MzgsMC42OTQ1ODMsMS4zMDYzMiwtMTg0Ljk0NSw3My4wMzA4KSI+CiAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMzU2LjQ2NSwyNDMuMjY1TDM1Ni4zNDIsNDgyLjc0OEwzNTcuNjE4LDQ4NC4wMzlMMzg0Ljk4OCw0NDQuNDA0TDM4NC45NDksMjM4Ljc0OCIKICAgICAgICAgICAgICAgICAgICAgIHN0eWxlPSJmaWxsOndoaXRlO3N0cm9rZTpyZ2IoNTQsNjQsMTU3KTtzdHJva2Utd2lkdGg6MS4wOHB4OyIvPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4K"},hBwV:function(t,e,a){"use strict";var n=a("TqRt");e.__esModule=!0,e.default=void 0;var i=n(a("cFM1")),M=function(t,e){return e+"("+(0,i.default)(t)+")"};e.default=M},"hxE/":function(t,e){t.exports="data:image/svg+xml;base64,PHN2ZyBoZWlnaHQ9IjIzMy44Nzg4OCIgdmlld0JveD0iMCAwIDI1NiAyMzMuODc4ODciIHdpZHRoPSIyNTYiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIKPgogIDxjbGlwUGF0aCBpZD0iYSI+CiAgICA8cGF0aCBkPSJtMCA2MDBoNjAwdi02MDBoLTYwMHoiLz4KICA8L2NsaXBQYXRoPgogIDxnIGNsaXAtcGF0aD0idXJsKCNhKSIgdHJhbnNmb3JtPSJtYXRyaXgoMS42IDAgMCAtMS42IC0zNTIgNTk2LjkzOTIpIj4KICAgIDxwYXRoCiAgICAgIGQ9Im0wIDBjLTQ0LjE4MyAwLTgwLTM1LjgxNy04MC04MCAwLTE1LjI1NCA0LjI3MS0yOS41MDkgMTEuNjc5LTQxLjYzOWwyMC45IDIyLjE5MSAxMDUuNzgzLS42NjEtLjc2Ni0zNS40MDdjMTMuODcxIDE0LjM4NyAyMi40MDQgMzMuOTU0IDIyLjQwNCA1NS41MTYgMCA0NC4xODMtMzUuODE3IDgwLTgwIDgwIgogICAgICBmaWxsPSIjMzNhMGZmIiB0cmFuc2Zvcm09InRyYW5zbGF0ZSgzMDAgMzYyLjQyODcpIi8+CiAgICA8cGF0aAogICAgICBkPSJtMCAwYy0zLjg5OS4yMzktNi44ODcgMy42MDgtNi42NiA3LjUxMWwuNTI5IDguNTQ3Yy4yMzIgMy43MzkgMy4zNSA2LjY2OSA3LjA5NyA2LjY2OS4xNCAwIC4yODEtLjAwNC40MjItLjAxM2w4LjU0Mi0uNTI5YzEuODktLjExNSAzLjYyNy0uOTYyIDQuODg1LTIuMzg2IDEuMjYtMS40MjQgMS44ODgtMy4yNTYgMS43NjctNS4xNTZsLS41MjQtOC41MTRjLS4wMzEtLjQ5Mi0uMTMtLjg4Mi0uMTkxLTEuMDk1bC0uMzA0LTEuNDg3LTUuNjIxLTQuMTYyeiIKICAgICAgZmlsbD0iIzNkY2M4ZSIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMjYzLjgzNjMgMzM5LjYyNzQpIi8+CiAgICA8cGF0aAogICAgICBkPSJtMCAwYy02LjAxIDAtMTEuMDA5LTQuNjk4LTExLjM4MS0xMC42OTZsLS41MjktOC41MzItLjAwMS0uMDE2LS4wMDEtLjAxNWMtLjM2NC02LjI1OSA0LjQzLTExLjY2MiAxMC42ODYtMTIuMDQ1bDguMzc1LS41MTggMy4xMjMtLjE5MyAyLjUxNSAxLjg2MiAzLjA0MiAyLjI1MSAyLjY0MyAxLjk1Ny42MDcgMi45NjdjLjEyLjQ1NS4yNSAxLjA2OC4yOTcgMS44MThsLjUyNCA4LjUyMmMuMTkyIDMuMDQ1LS44MTcgNS45OC0yLjgzOSA4LjI2Ni0yLjAxMyAyLjI3OC00LjggMy42MzgtNy44NDMgMy44MjNsLTguNTE4LjUyOGgtLjAxMmwtLjAxMy4wMDFjLS4yMjQuMDEzLS40NTEuMDItLjY3NS4wMm02LjM3OC0xOC42MjEuMzE0IDUuMDc1LTUuMDc2LjMxNC0uMzE1LTUuMDc2em0tNi4zNzggMTAuMDM2Yy4wNTYgMCAuMTEzLS4wMDIuMTctLjAwNWw4LjUyOC0uNTI5Yy43NDctLjA0NSAxLjQzNi0uMzggMS45MzMtLjk0My41LS41NjUuNzQ5LTEuMjkuNzAxLTIuMDQxbC0uNTI1LTguNTI0Yy0uMDA4LS4xMzItLjA2MS0uMjQ4LS4wODYtLjM3NGwtMy4wNDItMi4yNTItOC4zOC41MThjLTEuNTQ2LjA5NS0yLjczIDEuNDMtMi42NCAyLjk3N2wuNTI5IDguNTMxYy4wOTIgMS40ODkgMS4zMjcgMi42NDIgMi44MTIgMi42NDIiCiAgICAgIGZpbGw9IiMyODI4MjgiIHRyYW5zZm9ybT0idHJhbnNsYXRlKDI2NC44MDI1IDM2Ni42NDY4KSIvPgogICAgPHBhdGgKICAgICAgZD0ibTAgMGMtMzMuNDAyIDAtNjAuNDgtMjcuMDc4LTYwLjQ4LTYwLjQ4IDAtMTIuNDIxIDMuNzQ2LTIzLjk2NSAxMC4xNjctMzMuNTY5aDEwMy4wNTVjNS40MjQgOS45MDcgNy43MzggMjEuNjM3IDcuNzM4IDMzLjU2OSAwIDMwLjkxNC0yNy4wNzggNjAuNDgtNjAuNDggNjAuNDgiCiAgICAgIGZpbGw9IiNmZmYiIHRyYW5zZm9ybT0idHJhbnNsYXRlKDMwMCAzMjAuOTYyMykiLz4KICAgIDxnIGZpbGw9IiMyODI4MjciPgogICAgICA8cGF0aAogICAgICAgIGQ9Im0wIDBjLTM1LjcxNiAwLTY0Ljc3My0yOS4wNTctNjQuNzczLTY0Ljc3MyAwLTEyLjI4IDMuNDM2LTIzLjc3NCA5LjM5Ni0zMy41NjloMTAuMzQ3Yy03LjAwNSA5LjM3Mi0xMS4xNTcgMjAuOTk1LTExLjE1NyAzMy41NjkgMCAzMC45ODIgMjUuMjA1IDU2LjE4OCA1Ni4xODcgNTYuMTg4IDE0LjcxNiAwIDI4LjgxMS02LjE2MSAzOS42ODgtMTcuMzQ4IDEwLjQ4Ni0xMC43ODMgMTYuNS0yNC45NCAxNi41LTM4Ljg0IDAtOS41MTctMS41NzItMjIuNDUtOC40MDUtMzMuNTY5aDkuNzk5YzQuNzI5IDkuNTE5IDcuMTkxIDIwLjkgNy4xOTEgMzMuNTY5IDAgMTYuMTE2LTYuODk5IDMyLjQ1NC0xOC45MjkgNDQuODI2LTEyLjUwOCAxMi44NjMtMjguNzg5IDE5Ljk0Ny00NS44NDQgMTkuOTQ3IgogICAgICAgIHRyYW5zZm9ybT0idHJhbnNsYXRlKDI5OS45OTk5IDMyNS4yNTUpIi8+CiAgICAgIDxwYXRoCiAgICAgICAgZD0ibTAgMGMwLTMuMjA3LTIuNTk5LTUuODA2LTUuODA2LTUuODA2cy01LjgwNiAyLjU5OS01LjgwNiA1LjgwNiAyLjU5OSA1LjgwNiA1LjgwNiA1LjgwNiA1LjgwNi0yLjU5OSA1LjgwNi01LjgwNiIKICAgICAgICB0cmFuc2Zvcm09InRyYW5zbGF0ZSgyODcuNzg5MSAyNDIuOTI1NCkiLz4KICAgICAgPHBhdGgKICAgICAgICBkPSJtMCAwYzAtMy4yMDctMi41OTktNS44MDYtNS44MDYtNS44MDZzLTUuODA2IDIuNTk5LTUuODA2IDUuODA2IDIuNTk5IDUuODA2IDUuODA2IDUuODA2IDUuODA2LTIuNTk5IDUuODA2LTUuODA2IgogICAgICAgIHRyYW5zZm9ybT0idHJhbnNsYXRlKDMyMy44MjI4IDI0Mi45MjU0KSIvPgogICAgPC9nPgogICAgPHBhdGgKICAgICAgZD0ibTAgMCAzMi4yMjggMzQuMTgtNy43NTctMjQuMzE5YzI1LjE2MSAxOC4zMSA1MS41NzUgMTUuNDE1IDcwLjE3NCA5Ljk1MyAxOS43NDEtNS43OTYgMzMuNTYyIDExLjYzOSAyMC4wMzIgMzAuMjM4LTYuNDI5IDguODM5LTE1LjI0OCAxNi4xNzgtMjUuMjY1IDIwLjYyOS0yNi4yNzMgMTEuNjcxLTUyLjY4OCA0Ljg2Ni03MC41MDctMTMuMTM0LTE4Ljg3Ni0xOS4wNjgtMTguOTA1LTQwLjIxNy0xOC45MDUtNTcuNTQ3IgogICAgICBmaWxsPSIjZmY2ZjIxIiB0cmFuc2Zvcm09InRyYW5zbGF0ZSgyMzQuMDExNyAyNDUuMjI4NykiLz4KICAgIDxwYXRoCiAgICAgIGQ9Im0wIDBjLTMuNzQxIDAtNy40NTYtLjM3My0xMS4xMDctMS4xMjQtMTEuMTM1LTIuMjktMjEuNDczLTcuOTk5LTI5Ljg5Ny0xNi41MDktMTMuOTkzLTE0LjEzNS0xNi45MDEtMjkuMzA2LTE3LjUwNS00My41NDlsMzcuNjAzIDM5Ljg4MS05Ljk1NS0zMS4yMDhjMTguNzA4IDkuNzgxIDQwLjA5OSAxMS4yMjggNjMuNzU1IDQuMjgyIDcuNTI4LTIuMjEgMTQuMzUxLS41MzUgMTcuODA4IDQuMzcxIDMuNTUxIDUuMDQxIDIuNjMzIDEyLjIyNy0yLjQ1NiAxOS4yMjMtNi4wODEgOC4zNi0xNC40NCAxNS4xODktMjMuNTM3IDE5LjIzMS04LjA2OCAzLjU4NC0xNi40NSA1LjQwMi0yNC43MDkgNS40MDJtLTY3LjI1Mi04Mi45N3YxMC44MWMwIDE3LjkxNyAwIDQwLjIxNSAyMC4xNDYgNjAuNTY3IDkuNjIgOS43MTcgMjEuNDcgMTYuMjQ1IDM0LjI2OSAxOC44NzggMTMuNDc0IDIuNzcyIDI3LjY2MiAxLjA5OCA0MS4wMzItNC44NDEgMTAuNDUzLTQuNjQ0IDIwLjA0LTEyLjQ2NyAyNi45OTQtMjIuMDI2IDcuMjQzLTkuOTU4IDguMjEzLTIxLjE1NCAyLjUzMS0yOS4yMTgtNS41NTUtNy44ODUtMTYuMjQ3LTEwLjg5Mi0yNy4yNDUtNy42NjQtMjUuMzY0IDcuNDQ4LTQ3LjcxOCA0LjMxNy02Ni40MzgtOS4zMDZsLTEwLjYtNy43MTMgNi4wMDUgMTguODI1eiIKICAgICAgZmlsbD0iIzI4MjgyNyIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMjk2Ljk3MTYgMzE3LjM4ODYpIi8+CiAgICA8cGF0aAogICAgICBkPSJtMCAwYy0zLjgyMS05Ljk1Ni0xNC45MDEtMTUuNTE1LTI1LjE2Ny0xMi42MjUtMTEuNTY2IDMuMjU3LTE3LjY3MyAxMi41NTItMTYuMjA3IDI0LjM0MiAxLjQ1OSAxMS43MjUgOS4zODIgMjIuMDA1IDE4LjUxNSAzNC42NzctNy41MDItMTUuOTY5LTEuMTI5LTE3LjQ2NS44ODctMTcuMzg1IDEuOTkyLjA3OSA0LjktLjI2MSA5LjAzOS0xLjYzNCAxMS4yNzctMy43NDMgMTcuMjM4LTE2LjE1NyAxMi45MzMtMjcuMzc1IgogICAgICBmaWxsPSIjZmY2ZjIxIiB0cmFuc2Zvcm09InRyYW5zbGF0ZSgzMTUuNDM5NSAzMjQuMTgzNSkiLz4KICAgIDxwYXRoCiAgICAgIGQ9Im0wIDBjLTMuOTYyLTYuMjEyLTYuNzQ0LTExLjk4Ni03LjUwNC0xOC4wOTQtMS4yMDMtOS42NzMgMy42OTgtMTcuMDMgMTMuMTExLTE5LjY4IDguMTcyLTIuMzAxIDE2Ljk1NCAyLjEwNSAxOS45OTYgMTAuMDMgMS42NDkgNC4yOTggMS40NzcgOC45NDctLjQ4NCAxMy4wOTEtMS45NjMgNC4xNDgtNS40NDEgNy4yMjgtOS43OTQgOC42NzItMy44MiAxLjI2OC02LjE5OCAxLjQ2OS03LjUxNiAxLjQxOS0yLjk1OS0uMTE2LTUuNjkgMS4yNjItNy4zIDMuNjktLjE4Ni4yOC0uMzU2LjU3LS41MDkuODcybTkuOTc3LTQ2Ljk2M2MtMi4yMjYgMC00LjQ3NS4yOTktNi42OTcuOTI1LTYuNjY2IDEuODc3LTExLjk5MyA1LjU4Ny0xNS40MDQgMTAuNzI5LTMuNDAxIDUuMTI2LTQuNzQ5IDExLjQ0NS0zLjkgMTguMjc1IDEuNSAxMi4wNTcgOC45MzEgMjIuMzI5IDE3LjUzNSAzNC4yMjMuNTguODAyIDEuMTY2IDEuNjEyIDEuNzU4IDIuNDMzbDcuMzY3LTQuMzM1Yy0zLjYzNi03Ljc0MS0zLjIxOS0xMC42MDctMy4wMjgtMTEuMjYxIDIuOTI1LjA4OSA2LjQzMS0uNTM0IDEwLjQyMS0xLjg1OCA2LjYwMS0yLjE5MSAxMS44NzUtNi44NiAxNC44NS0xMy4xNDkgMi45NzQtNi4yODQgMy4yMzYtMTMuMzMuNzM5LTE5LjgzOS0zLjc4OC05Ljg2OS0xMy40NDYtMTYuMTQzLTIzLjY0MS0xNi4xNDMiCiAgICAgIGZpbGw9IiMyODI4MjciIHRyYW5zZm9ybT0idHJhbnNsYXRlKDI4NS44Mjk0IDM1My40NjUpIi8+CiAgICA8cGF0aAogICAgICBkPSJtMCAwYy0xLjUwMyAwLTIuOTExLjY2OC0zLjg2MSAxLjgzMmwtMi44ODggMy41MzdjLTEuNjc0IDIuMDUtMS40MzQgNS4wNDkuNTAxIDYuODExLS42MjUuMzA2LTEuMTg0Ljc0Ny0xLjYzOCAxLjMwM2wtLjY1OS44MDdjLTEuNzM0IDIuMTIzLTEuNDE3IDUuMjYuNzA1IDYuOTkzbC40MTUuMzM5LTQuMjMgNS4xOTJjLTEuODgxIDIuMzA0LTEuNTM2IDUuNzEzLjc3IDcuNTk3Ljk2Ny43ODggMi4xNzkgMS4yMTkgMy40MTcgMS4yMTkgMS42MjYgMCAzLjE1MS0uNzIyIDQuMTgyLTEuOTgybDE4LjA0My0yMi4yMDdjMS44NzgtMi4zMDEgMS41MzMtNS43MS0uNzczLTcuNTk0LS42MzYtLjUyLTEuMzk4LS44OTQtMi4yLTEuMDc5LS4zOTgtLjA5Mi0uODA4LS4xMzgtMS4yMTctLjEzOC0xLjQwNiAwLTIuNzM1LjUzOS0zLjczNiAxLjQ5OGwtMy42ODEtMy4wMDVjLS44ODctLjcyNC0yLjAwNi0xLjEyMy0zLjE1LTEuMTIzIgogICAgICBmaWxsPSIjM2RjYzhlIiB0cmFuc2Zvcm09InRyYW5zbGF0ZSgzMDQuNTkxNiAyODYuMTYxMykiLz4KICAgIDxwYXRoCiAgICAgIGQ9Im0wIDBjLTEuNzAxIDIuMDc4LTQuMjE2IDMuMjY5LTYuODk5IDMuMjY5LTIuMDQ0IDAtNC4wNDQtLjcxMi01LjYzMS0yLjAwNC0zLjgxNC0zLjExNi00LjM4Mi04Ljc0MS0xLjI3NS0xMi41NDdsMi4zNS0yLjg4NWMtMS43MjYtMi45NjgtMS41MzktNi44MjQuNzU4LTkuNjM3bC40NDItLjU0MmMtMS4wMzktMi43NDEtLjYzLTUuOTUgMS4zNTQtOC4zNzlsMi44ODgtMy41MzhjMS42MTktMS45ODQgNC4wMTgtMy4xMjIgNi41ODEtMy4xMjIgMS45NTIgMCAzLjg2LjY3OSA1LjM3MiAxLjkxNGwxLjczIDEuNDEyYzEuMDgyLS40NTUgMi4yNTctLjY5NyAzLjQ2Ni0uNjk3LjY3NCAwIDEuMzQ5LjA3NyAyLjAwNi4yMjkgMS4zMjQuMzA1IDIuNTguOTIxIDMuNjMzIDEuNzgxIDMuODA1IDMuMTA5IDQuMzczIDguNzM0IDEuMjY3IDEyLjU0bC0xOC4wMjUgMjIuMTg1em0tNi44OTktMy43NTVjLjU0NyAwIDEuMDktLjIzOCAxLjQ2NC0uNjk2bDE4LjAzNS0yMi4xOTZjLjY2LS44MDkuNTM5LTEuOTk5LS4yNjktMi42NTktLjIzMy0uMTktLjQ5Ni0uMzE0LS43NjktLjM3Ny0uMTQtLjAzMy0uMjgzLS4wNDktLjQyNi0uMDQ5LS41NDggMC0xLjA5MS4yMzctMS40NjUuNjk1bC0xLjc5NiAyLjIxMy02LjM3Ny01LjIwNWMtLjI3My0uMjI0LS42MDItLjMzMi0uOTMtLjMzMi0uNDI2IDAtLjg0OS4xODUtMS4xNC41NDFsLTIuODg4IDMuNTM3Yy0uNTA4LjYyMi0uNDE1IDEuNTM4LjIwNyAyLjA0Nmw2LjQwOCA1LjIzMS0yLjYxOCAzLjIyOC0zLjE3LTIuNTljLS4yNi0uMjExLS41NzItLjMxNC0uODgyLS4zMTQtLjQwNCAwLS44MDUuMTc1LTEuMDgxLjUxMmwtLjY2LjgwOWMtLjUwOS42MjMtLjQxNyAxLjU0MS4yMDYgMi4wNWwzLjEzMyAyLjU1OC02LjQ0NyA3LjkxM2MtLjY2LjgwOC0uNTM5IDEuOTk4LjI2OSAyLjY1OC4zNTMuMjg3Ljc3Ni40MjcgMS4xOTYuNDI3IgogICAgICBmaWxsPSIjMjgyODI4IiB0cmFuc2Zvcm09InRyYW5zbGF0ZSgzMDQuMDIyOSAzMjIuMDM0NSkiLz4KICA8L2c+Cjwvc3ZnPgo="},mCuS:function(t,e,a){t.exports=a.p+"static/RaspberryWalletFramed-955059753e816340c20906be43d695e0.png"},pf18:function(t,e,a){t.exports=a.p+"static/WishesLongFramed-224111de12ad537d93b57407f3512f55.png"},qorR:function(t,e,a){"use strict";var n=a("TqRt");Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var i=n(a("q1tI")),M=(0,n(a("8/g6")).default)(i.default.createElement(i.default.Fragment,null,i.default.createElement("path",{fill:"none",d:"M0 0h24v24H0z"}),i.default.createElement("path",{d:"M4 6H2v14c0 1.1.9 2 2 2h14v-2H4V6zm16-4H8c-1.1 0-2 .9-2 2v12c0 1.1.9 2 2 2h12c1.1 0 2-.9 2-2V4c0-1.1-.9-2-2-2zm-1 9H9V9h10v2zm-4 4H9v-2h6v2zm4-8H9V5h10v2z"})),"LibraryBooks");e.default=M},rzV7:function(t,e,a){"use strict";a("rzGZ"),a("Dq+y"),a("8npG"),a("Ggvi");var n=Object.prototype.hasOwnProperty;function i(t,e){return t===e?0!==t||0!==e||1/t==1/e:t!=t&&e!=e}t.exports=function(t,e){if(i(t,e))return!0;if("object"!=typeof t||null===t||"object"!=typeof e||null===e)return!1;var a=Object.keys(t),M=Object.keys(e);if(a.length!==M.length)return!1;for(var o=0;o<a.length;o++)if(!n.call(e,a[o])||!i(t[a[o]],e[a[o]]))return!1;return!0}},tv6k:function(t,e,a){t.exports=a.p+"static/TaxLedgerLogo-7fc1e6f1fdb533b2cd8dae1702f1a485.svg"},u5Ab:function(t,e,a){t.exports=a.p+"static/GoLureLongFramed-4f47a5bd2087dcf98e9a2c8ce3ed1581.webp"},uVIg:function(t,e,a){t.exports=a.p+"static/GoLureLongFramed-e20bd3bff19eecf85e030460ec42ace7.png"}}]);
//# sourceMappingURL=component---src-pages-index-tsx-64c848aafe193463701f.js.map