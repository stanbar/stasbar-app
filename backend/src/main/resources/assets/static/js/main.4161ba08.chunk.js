(window.webpackJsonp=window.webpackJsonp||[]).push([[0],{100:function(e,t,a){e.exports=a.p+"static/media/KeybaseLogo.256c7062.svg"},101:function(e,t,a){e.exports=a.p+"static/media/StackOverflowIcon.3ae582d5.svg"},102:function(e,t,a){e.exports=a.p+"static/media/VapeToolLogo.3e2427a7.svg"},103:function(e,t,a){e.exports=a.p+"static/media/TaxLedgerLogo.7fc1e6f1.svg"},104:function(e,t,a){e.exports=a.p+"static/media/VapeToolLongFramed.8e23a94d.png"},105:function(e,t,a){e.exports=a.p+"static/media/GoLureLongFramed.e20bd3bf.png"},106:function(e,t,a){e.exports=a.p+"static/media/Wallpapers4KLongFramed.8c15a6bd.png"},107:function(e,t,a){e.exports=a.p+"static/media/WallpapersOneClickLongFramed.dc77aea2.png"},108:function(e,t,a){e.exports=a.p+"static/media/WishesLongFramed.224111de.png"},109:function(e,t,a){e.exports=a.p+"static/media/TaxLedgerFramed.7e25a979.png"},110:function(e,t,a){e.exports=a.p+"static/media/VapeToolLongFramed.41166ef3.webp"},111:function(e,t,a){e.exports=a.p+"static/media/GoLureLongFramed.4f47a5bd.webp"},112:function(e,t,a){e.exports=a.p+"static/media/Wallpapers4KLongFramed.843ab7e0.webp"},113:function(e,t,a){e.exports=a.p+"static/media/WallpapersOneClickLongFramed.83bf14cd.webp"},114:function(e,t,a){e.exports=a.p+"static/media/WishesLongFramed.16c18fde.webp"},115:function(e,t,a){e.exports=a.p+"static/media/TaxLedgerFramed.2c4365ee.webp"},116:function(e,t,a){e.exports=a.p+"static/media/RaspberryWalletFramed.f9f589d5.png"},117:function(e,t,a){e.exports=a.p+"static/media/RaspberryWalletFramed.ccecf37c.webp"},118:function(e,t,a){e.exports=a.p+"static/media/WebsiteFramed.ad986fb9.png"},119:function(e,t,a){e.exports=a.p+"static/media/WebsiteFramed.bab27de6.webp"},214:function(e,t,a){e.exports=a(318)},221:function(e,t,a){},318:function(e,t,a){"use strict";a.r(t);var n=a(0),r=a.n(n),o=a(34),c=a.n(o),i=a(27),s=a(21),l=a(2),p=a(322),m=a(321),u=a(324),g=(a(221),a(12)),h=a.n(g),d=a(17),f=a(7),b=a(8),y=a(10),j=a(9),E=a(11),x=a(4),k=a(45),v=a(320),w="production"===Object({NODE_ENV:"production",PUBLIC_URL:""}).REACT_APP_STAGE?window.location.origin:"",O={fetchAllBooks:function(){var e=Object(d.a)(h.a.mark(function e(){var t;return h.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,fetch(w+"/api/books?shelf=read");case 2:if(!(t=e.sent).ok){e.next=9;break}return e.next=6,t.json();case 6:return e.abrupt("return",e.sent);case 9:throw console.error(t),Error(t.statusText);case 11:case"end":return e.stop()}},e)}));return function(){return e.apply(this,arguments)}}(),fetchFeaturedBooks:function(){var e=Object(d.a)(h.a.mark(function e(){var t;return h.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,fetch(w+"/api/books?shelf=featured");case 2:if(!(t=e.sent).ok){e.next=9;break}return e.next=6,t.json();case 6:return e.abrupt("return",e.sent);case 9:throw console.error(t),Error(t.statusText);case 11:case"end":return e.stop()}},e)}));return function(){return e.apply(this,arguments)}}(),fetchProgrammingBooks:function(){var e=Object(d.a)(h.a.mark(function e(){var t;return h.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,fetch(w+"/api/books?shelf=programming");case 2:if(!(t=e.sent).ok){e.next=9;break}return e.next=6,t.json();case 6:return e.abrupt("return",e.sent);case 9:throw console.error(t),Error(t.statusText);case 11:case"end":return e.stop()}},e)}));return function(){return e.apply(this,arguments)}}(),fetchAllQuotes:function(){var e=Object(d.a)(h.a.mark(function e(){var t;return h.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,fetch(w+"/api/quotes");case 2:if(!(t=e.sent).ok){e.next=9;break}return e.next=6,t.json();case 6:return e.abrupt("return",e.sent);case 9:throw console.error(t),Error(t.statusText);case 11:case"end":return e.stop()}},e)}));return function(){return e.apply(this,arguments)}}(),fetchFeaturedQuotes:function(){var e=Object(d.a)(h.a.mark(function e(){var t;return h.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,fetch(w+"/api/quotes?limit=10");case 2:if(!(t=e.sent).ok){e.next=9;break}return e.next=6,t.json();case 6:return e.abrupt("return",e.sent);case 9:throw console.error(t),Error(t.statusText);case 11:case"end":return e.stop()}},e)}));return function(){return e.apply(this,arguments)}}()},S=function(e){function t(){return Object(f.a)(this,t),Object(y.a)(this,Object(j.a)(t).apply(this,arguments))}return Object(E.a)(t,e),Object(b.a)(t,[{key:"render",value:function(){var e=this.props.book;return r.a.createElement("div",{id:e.hash},r.a.createElement("h3",null,"Title: ",e.title),r.a.createElement("h3",null,"Author: ",e.author),r.a.createElement("h3",null,"Rating: ",e.rating))}}]),t}(n.Component),C=function(e){function t(e){var a;return Object(f.a)(this,t),(a=Object(y.a)(this,Object(j.a)(t).call(this,e))).state={books:new Array,loading:!0},a.fetchBooks(),a}return Object(E.a)(t,e),Object(b.a)(t,[{key:"render",value:function(){var e=this.props,t=e.match,a=e.classes,n=this.state,o=n.books,c=n.loading;return r.a.createElement("div",{className:a.root},r.a.createElement(l.e,{container:!0,spacing:16},c&&r.a.createElement(l.e,{item:!0,sm:12},r.a.createElement(l.j,{variant:"h5"},"Loading...")),o.map(function(e){return r.a.createElement(l.e,{key:e.hash,item:!0,xs:4,sm:3,md:3,lg:2,style:{height:"auto",width:"100%"}},r.a.createElement(l.f,{component:function(a){return r.a.createElement(v.a,Object.assign({},a,{to:"".concat(t.url,"/").concat(e.hash)}))}},r.a.createElement("img",{src:e.imageUrl,alt:e.title,className:a.img}),r.a.createElement(l.g,{title:e.title,subtitle:r.a.createElement("span",null,"by: ",e.author)})))})),r.a.createElement(k.a,{path:"".concat(t.path,"/:hash"),component:function(e){return r.a.createElement(S,Object.assign({},e,{book:o.find(function(t){return t.hash===e.match.params.hash})}))}}))}},{key:"fetchBooks",value:function(){var e=Object(d.a)(h.a.mark(function e(){var t;return h.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,O.fetchAllBooks();case 3:t=e.sent,this.setState({books:t,loading:!1}),e.next=11;break;case 7:e.prev=7,e.t0=e.catch(0),console.error(e.t0),this.setState({loading:!1});case 11:case"end":return e.stop()}},e,this,[[0,7]])}));return function(){return e.apply(this,arguments)}}()}]),t}(n.Component),N=Object(s.withStyles)(function(e){var t;return Object(s.createStyles)({root:(t={width:"auto",marginLeft:3*e.spacing.unit,marginRight:3*e.spacing.unit},Object(x.a)(t,e.breakpoints.up(1100+3*e.spacing.unit*2),{width:1100,marginLeft:"auto",marginRight:"auto"}),Object(x.a)(t,"display","flex"),Object(x.a)(t,"flexWrap","wrap"),Object(x.a)(t,"flexGrow",1),Object(x.a)(t,"flexDirection","column"),Object(x.a)(t,"justifyContent","space-around"),Object(x.a)(t,"overflow","hidden"),Object(x.a)(t,"padding","".concat(8*e.spacing.unit,"px 0")),t),img:{width:"100%",height:"auto"}})})(C),L=a(96),F=a(323),B=a(120),W=a(35),A=a.n(W),T=a(47),I=a.n(T),P=a(48),R=a.n(P),G=function(e){function t(){return Object(f.a)(this,t),Object(y.a)(this,Object(j.a)(t).apply(this,arguments))}return Object(E.a)(t,e),Object(b.a)(t,[{key:"render",value:function(){var e=this.props.classes;return n.createElement("footer",{className:this.props.classes.footer},n.createElement(l.j,{variant:"h6",align:"center",gutterBottom:!0},n.createElement(l.b,{href:"https://github.com/stasbar/stasbar-app"},"Source Code")),n.createElement(l.j,{variant:"subtitle1",align:"center",color:"textSecondary",component:"p"},"build with ",n.createElement("a",{className:e.link,href:"https://kotlinlang.org/"},"Kotlin \u2764\ufe0f")," hosted on ",n.createElement("a",{className:e.link,href:"https://ipfs.io/"},"IPFS")))}}]),t}(n.Component),D=Object(s.withStyles)(function(e){return Object(s.createStyles)({footer:{backgroundColor:e.palette.background.paper,padding:6*e.spacing.unit},link:{textDecoration:"none",color:e.palette.text.primary}})})(G),V=(a(90),a(98)),Q=a.n(V),M=function(e){function t(){return Object(f.a)(this,t),Object(y.a)(this,Object(j.a)(t).apply(this,arguments))}return Object(E.a)(t,e),Object(b.a)(t,[{key:"render",value:function(){var e=this.props,t=e.classes,a=e.children,r=n.createElement(l.a,{position:"static",className:t.appBar},n.createElement(l.i,null,n.createElement("div",{style:{flexGrow:1}},n.createElement(v.a,{to:"/"},n.createElement("img",{className:t.logoImg,src:Q.a}))),n.createElement(A.a,{className:t.menuButton,variant:"outlined",component:v.a,to:"/books"},"Books",n.createElement(I.a,{className:t.rightIcon})),n.createElement(A.a,{className:t.menuButton,variant:"outlined",component:v.a,to:"/quotes"},"Quotes",n.createElement(R.a,{className:t.rightIcon}))));return n.createElement(n.Fragment,null,n.createElement(l.d,null),r,n.createElement("main",{className:t.main},a),n.createElement(D,null))}}]),t}(n.Component),q=Object(B.a)(F.a,Object(s.withStyles)(function(e){var t;return{appBar:{position:"relative"},main:{flexGrow:1},logoImg:(t={},Object(x.a)(t,e.breakpoints.down(500+3*e.spacing.unit*2),{marginRight:20,marginLeft:-12}),Object(x.a)(t,"maxHeight",50),t),menuButton:Object(x.a)({marginRight:0,marginLeft:0,color:e.palette.secondary.dark},e.breakpoints.up(500+3*e.spacing.unit*2),{marginRight:20,marginLeft:-12}),rightIcon:{marginLeft:e.spacing.unit},content:{display:"flex",flexGrow:1,padding:3*e.spacing.unit},mainPaper:Object(L.a)({flexGrow:1,alignSelf:"center"},e.mixins.gutters(),{maxWidth:1200,paddingTop:2*e.spacing.unit,paddingBottom:2*e.spacing.unit})}}))(M);function K(e){return n.createElement(l.h,e,n.createElement("path",{fill:"#006CAC",d:"M19,3A2,2 0 0,1 21,5V19A2,2 0 0,1 19,21H5A2,2 0 0,1 3,19V5A2,2 0 0,1 5,3H19M18.5,18.5V13.2A3.26,3.26 0 0,0 15.24,9.94C14.39,9.94 13.4,10.46 12.92,11.24V10.13H10.13V18.5H12.92V13.57C12.92,12.8 13.54,12.17 14.31,12.17A1.4,1.4 0 0,1 15.71,13.57V18.5H18.5M6.88,8.56A1.68,1.68 0 0,0 8.56,6.88C8.56,5.95 7.81,5.19 6.88,5.19A1.69,1.69 0 0,0 5.19,6.88C5.19,7.81 5.95,8.56 6.88,8.56M8.27,18.5V10.13H5.5V18.5H8.27Z"}))}function H(e){return n.createElement(l.h,e,n.createElement("path",{d:"M12,2A10,10 0 0,0 2,12C2,16.42 4.87,20.17 8.84,21.5C9.34,21.58 9.5,21.27 9.5,21C9.5,20.77 9.5,20.14 9.5,19.31C6.73,19.91 6.14,17.97 6.14,17.97C5.68,16.81 5.03,16.5 5.03,16.5C4.12,15.88 5.1,15.9 5.1,15.9C6.1,15.97 6.63,16.93 6.63,16.93C7.5,18.45 8.97,18 9.54,17.76C9.63,17.11 9.89,16.67 10.17,16.42C7.95,16.17 5.62,15.31 5.62,11.5C5.62,10.39 6,9.5 6.65,8.79C6.55,8.54 6.2,7.5 6.75,6.15C6.75,6.15 7.59,5.88 9.5,7.17C10.29,6.95 11.15,6.84 12,6.84C12.85,6.84 13.71,6.95 14.5,7.17C16.41,5.88 17.25,6.15 17.25,6.15C17.8,7.5 17.45,8.54 17.35,8.79C18,9.5 18.38,10.39 18.38,11.5C18.38,15.32 16.04,16.16 13.81,16.41C14.17,16.72 14.5,17.33 14.5,18.26C14.5,19.6 14.5,20.68 14.5,21C14.5,21.27 14.66,21.59 15.17,21.5C19.14,20.16 22,16.42 22,12A10,10 0 0,0 12,2Z"}))}var _=a(100),z=a.n(_),U=a(101),J=a.n(U),Z=a(102),Y=a.n(Z),$=a(103),X=a.n($),ee=function(e){function t(){return Object(f.a)(this,t),Object(y.a)(this,Object(j.a)(t).apply(this,arguments))}return Object(E.a)(t,e),Object(b.a)(t,[{key:"render",value:function(){var e=this.props.classes;var t=function(t){return n.createElement(l.e,{item:!0,className:e.intentButton},n.createElement(i.a,{to:t.href,eventLabel:t.name,target:"_blank",style:{textDecoration:"none"}},n.createElement(l.b,{variant:"contained",color:"primary",style:{color:t.textColor,backgroundColor:t.backgroundColor}},t.Icon,t.name)))};return n.createElement("div",{className:e.content},n.createElement(l.j,{variant:"h1",align:"center",gutterBottom:!0,className:e.nameTitle},"STANISLAW BARANSKI"),n.createElement(l.j,{variant:"h6",align:"center",gutterBottom:!0},n.createElement("u",{className:e.keyword},"full stack android developer"),", \xa0",n.createElement("u",{className:e.keyword},"beginner entrepreneur"),", \xa0",n.createElement("u",{className:e.keyword},"blockchain enthusiast"),", \xa0",n.createElement("u",{className:e.keyword},"b.eng. computer science"),", \xa0",n.createElement("u",{className:e.keyword},(new Date).getUTCFullYear()-1995," years old")),n.createElement(l.e,{container:!0,spacing:0,justify:"center",className:e.buttons},n.createElement(t,{name:"LinkedIn",href:"https://www.linkedin.com/in/stasbar/",Icon:n.createElement(K,null),textColor:"#243641",backgroundColor:"#FFF"}),n.createElement(t,{name:"Github",href:"https://github.com/stasbar",Icon:n.createElement(H,null),textColor:"#FFF",backgroundColor:"#212529"}),n.createElement(t,{name:"Keybase",href:"https://keybase.io/stasbar",Icon:n.createElement("img",{src:z.a,width:20}),textColor:"#FFF",backgroundColor:"#3095F4"}),n.createElement(t,{name:"StackOverflow",href:"https://stackoverflow.com/story/stasbar",Icon:n.createElement("img",{src:J.a,width:20}),textColor:"#343536",backgroundColor:"#F9F9FA"}),n.createElement(t,{name:"TaxLedger",href:"https://tax-ledger.com",Icon:n.createElement("img",{src:X.a,width:20}),textColor:"#243641",backgroundColor:"#FFF"}),n.createElement(t,{name:"VapeTool",href:"https://vapetool.app",Icon:n.createElement("img",{src:Y.a,width:20}),textColor:"#FFF",backgroundColor:"#3546A7"})),n.createElement(l.e,{container:!0,spacing:0,justify:"center",className:e.specs},n.createElement(l.e,{item:!0,xs:6,sm:6,md:3,lg:3,className:e.specGridItem},n.createElement(l.j,{className:e.specName},"Android"),n.createElement(l.j,{component:"p",color:"textSecondary"},"My main specialty is mobile applications for Android in Java and Kotlin.")),n.createElement(l.e,{item:!0,xs:6,sm:6,md:3,lg:3,className:e.specGridItem},n.createElement(l.j,{className:e.specName},"Backend"),n.createElement(l.j,{component:"p",color:"textSecondary"},"I chose Firebase whenever it's possible. Otherwise Kotlin with ktor. And Python for scripting")),n.createElement(l.e,{item:!0,xs:6,sm:6,md:3,lg:3,className:e.specGridItem},n.createElement(l.j,{className:e.specName},"Frontend"),n.createElement(l.j,{component:"p",color:"textSecondary"},"I prefer reusability over simplicity, that's why I use React with TypeScript")),n.createElement(l.e,{item:!0,xs:6,sm:6,md:3,lg:3,className:e.specGridItem},n.createElement(l.j,{className:e.specName},"Tools"),n.createElement(l.j,{component:"p",color:"textSecondary"},"When it comes to tools I love IntelliJ & Android Studio running on macOS"))))}}]),t}(n.Component),te=Object(s.withStyles)(function(e){return Object(s.createStyles)({nameTitle:{fontSize:"2rem",fontWeight:600,marginBottom:"1rem",color:e.palette.text.primary},content:{maxWidth:600,margin:"0 auto",padding:"".concat(8*e.spacing.unit,"px 0 ").concat(6*e.spacing.unit,"px")},buttons:{marginTop:4*e.spacing.unit},intentButton:{margin:e.spacing.unit},specs:{marginTop:4*e.spacing.unit},keyword:{color:e.palette.secondary.main,borderBottom:".1rem solid currentColor",textDecoration:"none",textOverflow:"ellipsis",whiteSpace:"nowrap"},specGridItem:{background:"inherit",padding:e.spacing.unit},specName:{color:e.palette.secondary.main,margin:e.spacing.unit,fontSize:"1rem",fontWeight:700,textAlign:"center"}})})(ee),ae=function(e){function t(){return Object(f.a)(this,t),Object(y.a)(this,Object(j.a)(t).apply(this,arguments))}return Object(E.a)(t,e),Object(b.a)(t,[{key:"render",value:function(){var e=this.props.classes;return n.createElement("div",{className:e.heroContent},n.createElement(l.j,{variant:"h6",align:"center",color:"textSecondary",paragraph:!0},"Motivated by the newest technologies and business opportunities. Currently focusing on blockchain technology. Key values in my life:",n.createElement("br",null),"Efficiency\ud83c\udfcd\ufe0f, Development\ud83d\ude80, Adaptation\ud83e\udd8e, Freedom\ud83c\udf0e and Simplicity\ud83c\udf4e"))}}]),t}(n.Component),ne=Object(s.withStyles)(function(e){return Object(s.createStyles)({heroContent:{maxWidth:700,margin:"0 auto",padding:"".concat(8*e.spacing.unit,"px 0 ").concat(6*e.spacing.unit,"px")}})})(ae),re=function(e){function t(){return Object(f.a)(this,t),Object(y.a)(this,Object(j.a)(t).apply(this,arguments))}return Object(E.a)(t,e),Object(b.a)(t,[{key:"render",value:function(){var e=this.props,t=e.app,a=e.classes,r=function(e){return n.createElement("a",{className:a.link,href:e.href},e.text)};return n.createElement(l.e,{item:!0,sm:"mobile"===t.platform?3:6,md:"mobile"===t.platform?3:6,lg:"mobile"===t.platform?3:6,className:a.root},n.createElement(l.j,{variant:"h4",color:"secondary",className:a.name},t.name),n.createElement("picture",null,n.createElement("source",{srcSet:t.imgSrc,type:"image/png",className:a.img}),n.createElement("source",{srcSet:t.imgWebp,type:"image/webp",className:a.img}),n.createElement("img",{src:t.imgSrc,alt:t.name,className:a.img})),n.createElement(l.j,{className:a.description},t.description,t.links.googlePlay&&t.links.appStore&&". Both on ",t.links.googlePlay&&t.links.appStore&&n.createElement(r,{href:t.links.googlePlay,text:"Android"}),t.links.googlePlay&&t.links.appStore&&" and ",t.links.googlePlay&&t.links.appStore&&n.createElement(r,{href:t.links.appStore,text:"iOS"}),t.links.googlePlay&&!t.links.appStore&&". Check out on ",t.links.googlePlay&&!t.links.appStore&&n.createElement(r,{href:t.links.googlePlay,text:"Google Play"}),t.links.github&&". Check it out on ",t.links.github&&n.createElement(r,{href:t.links.github,text:"Github"}),t.links.website&&". See ",t.links.website&&n.createElement(r,{href:t.links.website,text:"website"})))}}]),t}(n.Component),oe=Object(s.withStyles)(function(e){return Object(s.createStyles)({root:{display:"flex",alignSelf:"flex-start",flexDirection:"column",justifyItems:"center",alignItems:"center",textDecoration:"none"},name:{marginBottom:e.spacing.unit,fontSize:"1rem",fontWeight:700},img:{height:"auto",width:"100%"},description:{textAlign:"justify",textDecoration:"none",color:e.palette.text.secondary,fontSize:"1rem"},link:{textDecoration:"none",borderBottom:".1rem solid currentColor",paddingBottom:"0.05rem",color:e.palette.text.primary,"&:hover":{color:e.palette.secondary.main}}})})(re),ce=function(e){function t(){return Object(f.a)(this,t),Object(y.a)(this,Object(j.a)(t).apply(this,arguments))}return Object(E.a)(t,e),Object(b.a)(t,[{key:"render",value:function(){var e=this.props.classes;return n.createElement("div",{className:e.root},n.createElement(l.j,{variant:"h2",align:"center",color:"textPrimary",gutterBottom:!0,className:e.nameTitle},this.props.title),n.createElement("div",{className:e.layout},n.createElement(l.e,{container:!0,justify:"center",spacing:40,style:{alignContent:"flex-start",alignItems:"stretch",flexGrow:1}},this.props.apps.map(function(e){return n.createElement(oe,{key:e.name,app:e})}))))}}]),t}(n.Component),ie=Object(s.withStyles)(function(e){var t;return Object(s.createStyles)({root:{margin:"0 auto",padding:"".concat(8*e.spacing.unit,"px 0 ").concat(6*e.spacing.unit,"px")},nameTitle:{fontWeight:500,fontSize:"2rem"},layout:(t={width:"auto",marginLeft:3*e.spacing.unit,marginRight:3*e.spacing.unit,padding:"".concat(8*e.spacing.unit,"px 0")},Object(x.a)(t,e.breakpoints.up(800+3*e.spacing.unit*2),{width:800,marginLeft:"auto",marginRight:"auto"}),Object(x.a)(t,"display","flex"),Object(x.a)(t,"flexWrap","wrap"),Object(x.a)(t,"flexGrow",1),Object(x.a)(t,"flexDirection","column"),Object(x.a)(t,"justifyContent","space-around"),Object(x.a)(t,"overflow","hidden"),t)})})(ce),se=a(104),le=a.n(se),pe=a(105),me=a.n(pe),ue=a(106),ge=a.n(ue),he=a(107),de=a.n(he),fe=a(108),be=a.n(fe),ye=a(109),je=a.n(ye),Ee=a(110),xe=a.n(Ee),ke=a(111),ve=a.n(ke),we=a(112),Oe=a.n(we),Se=a(113),Ce=a.n(Se),Ne=a(114),Le=a.n(Ne),Fe=a(115),Be=a.n(Fe),We=[{name:"Vape Tool",imgSrc:le.a,imgWebp:xe.a,description:"Fully fledged utility arsenal and social media for Vapers. Over 1M downloads and 300k active users",platform:"mobile",links:{website:"https://vapetool.stasbar.com",github:null,googlePlay:"https://play.google.com/store/apps/details?id=com.stasbar.vape_tool",appStore:"https://itunes.apple.com/us/app/coil-builder/id1210289983?mt=8"}},{name:"Tax Ledger",imgSrc:je.a,imgWebp:Be.a,description:"Desktop application for settle taxes from cryptocurrencies exchanges",platform:"desktop",links:{website:"https://tax-ledger.com",github:null,googlePlay:null,appStore:null}},{name:"4K Wallpapers",imgSrc:ge.a,imgWebp:Oe.a,description:"High resolution wallpapers",platform:"mobile",links:{website:null,github:null,googlePlay:"https://play.google.com/store/apps/details?id=com.wallpapers.new_wallpapers4k",appStore:null}},{name:"Go Lure",imgSrc:me.a,imgWebp:ve.a,description:"Catching the Pokemon Go hype, with addon scheduler for lure module party on a map",platform:"mobile",links:{website:null,github:null,googlePlay:"https://play.google.com/store/apps/details?id=com.stasbar.golure",appStore:null}},{name:"Easy Wallpapers",imgSrc:de.a,imgWebp:Ce.a,description:"Easy to use wallpaper apps build with many category flavors",platform:"mobile",links:{website:null,github:null,googlePlay:"https://play.google.com/store/apps/details?id=com.david_wallpapers.city_night",appStore:null}},{name:"Wishes",imgSrc:be.a,imgWebp:Le.a,description:"Wishes application for many occasion flavors",platform:"mobile",links:{website:null,github:null,googlePlay:"https://play.google.com/store/apps/details?id=com.allwishes.christmas",appStore:null}}],Ae=a(116),Te=a.n(Ae),Ie=a(117),Pe=a.n(Ie),Re=a(118),Ge=a.n(Re),De=a(119),Ve=a.n(De),Qe=[{name:"Raspberry Wallet",imgSrc:Te.a,imgWebp:Pe.a,description:"Bitcoin hardware wallet on Raspberry Pi Zero",platform:"desktop",links:{website:"https://raspberrywallet.github.io/readme.html",github:"https://github.com/RaspberryWallet",googlePlay:null,appStore:null}},{name:"website",imgSrc:Ge.a,imgWebp:Ve.a,description:"This website & android app itself is my pet-project, so I think it's worth mention here",platform:"desktop",links:{website:null,github:"https://github.com/stasbar/stasbar-app",googlePlay:null,appStore:null}}],Me=function(e){function t(e){var a;return Object(f.a)(this,t),(a=Object(y.a)(this,Object(j.a)(t).call(this,e))).state={books:new Array,loading:!0},a.fetchBooks(),a}return Object(E.a)(t,e),Object(b.a)(t,[{key:"render",value:function(){var e=this.props,t=e.match,a=e.classes,n=this.state,o=n.books,c=n.loading;return r.a.createElement("div",{className:a.root},r.a.createElement(l.j,{variant:"h2",align:"center",color:"textPrimary",gutterBottom:!0,className:a.nameTitle},"My favorite books"),r.a.createElement("div",{className:a.layout},r.a.createElement(l.e,{container:!0,spacing:40,justify:"center"},c&&r.a.createElement(l.e,{item:!0,sm:12},r.a.createElement(l.j,{variant:"h5"},"Loading...")),o.map(function(e){return r.a.createElement(l.e,{key:e.hash,item:!0,xs:6,sm:3,md:2,lg:2,style:{height:"auto",width:"100%"}},r.a.createElement(l.f,{component:function(a){return r.a.createElement(v.a,Object.assign({},a,{to:"".concat(t.url,"/").concat(e.hash)}))}},r.a.createElement("img",{src:e.imageUrl,alt:e.title,className:a.img}),r.a.createElement(l.g,{title:e.title,subtitle:r.a.createElement("span",null,"by: ",e.author)})))})),r.a.createElement(l.b,{className:a.moreBooksButton,variant:"outlined",component:function(e){return r.a.createElement(v.a,Object.assign({},e,{to:"/books"}))},color:"secondary"},"Books",r.a.createElement(I.a,{className:a.rightIcon}))))}},{key:"fetchBooks",value:function(){var e=Object(d.a)(h.a.mark(function e(){var t;return h.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,O.fetchFeaturedBooks();case 3:t=e.sent,this.setState({books:t,loading:!1}),e.next=11;break;case 7:e.prev=7,e.t0=e.catch(0),console.error(e.t0),this.setState({loading:!1});case 11:case"end":return e.stop()}},e,this,[[0,7]])}));return function(){return e.apply(this,arguments)}}()}]),t}(n.Component),qe=Object(s.withStyles)(function(e){var t;return Object(s.createStyles)({root:{margin:"0 auto",padding:"".concat(8*e.spacing.unit,"px 0 ").concat(6*e.spacing.unit,"px")},layout:(t={width:"auto",marginLeft:3*e.spacing.unit,marginRight:3*e.spacing.unit},Object(x.a)(t,e.breakpoints.up(1100+3*e.spacing.unit*2),{width:1100,marginLeft:"auto",marginRight:"auto"}),Object(x.a)(t,"display","flex"),Object(x.a)(t,"flexWrap","wrap"),Object(x.a)(t,"flexGrow",1),Object(x.a)(t,"flexDirection","column"),Object(x.a)(t,"justifyContent","space-around"),Object(x.a)(t,"overflow","hidden"),Object(x.a)(t,"padding","".concat(8*e.spacing.unit,"px 0")),t),img:{width:"100%",height:"auto"},nameTitle:{fontWeight:500,fontSize:"2rem"},moreBooksButton:{width:"auto",alignSelf:"center",marginTop:50,marginLeft:-12,marginRight:20},rightIcon:{marginLeft:e.spacing.unit}})})(Me),Ke=function(e){function t(e){var a;return Object(f.a)(this,t),(a=Object(y.a)(this,Object(j.a)(t).call(this,e))).state={quotes:new Array,loading:!0},a.fetchQuotes(),a}return Object(E.a)(t,e),Object(b.a)(t,[{key:"render",value:function(){var e=this.props,t=e.match,a=e.classes,n=this.state,o=n.quotes,c=n.loading;return r.a.createElement("div",{className:a.root},r.a.createElement(l.j,{variant:"h2",align:"center",color:"textPrimary",gutterBottom:!0,className:a.nameTitle},"My favorite quotes"),r.a.createElement("div",{className:a.layout},c&&r.a.createElement(l.e,{item:!0,sm:12},r.a.createElement(l.j,{variant:"h5"},"Loading...")),o.map(function(e){return r.a.createElement(l.c,{key:e.hash,className:a.cardQuote,component:function(a){return r.a.createElement(v.a,Object.assign({},a,{to:"".concat(t.url,"/").concat(e.hash)}))}},r.a.createElement(l.j,{variant:"body1"},r.a.createElement("i",null,e.text)," ~",e.author))}),r.a.createElement(l.b,{className:a.moreQuotesButton,variant:"outlined",component:function(e){return r.a.createElement(v.a,Object.assign({},e,{to:"/quotes"}))},color:"secondary"},"Quotes",r.a.createElement(R.a,{className:a.rightIcon}))))}},{key:"fetchQuotes",value:function(){var e=Object(d.a)(h.a.mark(function e(){var t;return h.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,O.fetchFeaturedQuotes();case 3:t=e.sent,this.setState({quotes:t,loading:!1}),e.next=11;break;case 7:e.prev=7,e.t0=e.catch(0),console.error(e.t0),this.setState({loading:!1});case 11:case"end":return e.stop()}},e,this,[[0,7]])}));return function(){return e.apply(this,arguments)}}()}]),t}(n.Component),He=Object(s.withStyles)(function(e){var t;return Object(s.createStyles)({root:{margin:"0 auto",padding:"".concat(8*e.spacing.unit,"px 0 ").concat(6*e.spacing.unit,"px")},layout:(t={width:"auto",marginLeft:3*e.spacing.unit,marginRight:3*e.spacing.unit},Object(x.a)(t,e.breakpoints.up(1100+3*e.spacing.unit*2),{width:1100,marginLeft:"auto",marginRight:"auto"}),Object(x.a)(t,"display","flex"),Object(x.a)(t,"flexWrap","wrap"),Object(x.a)(t,"flexGrow",1),Object(x.a)(t,"flexDirection","column"),Object(x.a)(t,"justifyContent","space-around"),Object(x.a)(t,"overflow","hidden"),Object(x.a)(t,"padding","".concat(8*e.spacing.unit,"px 0")),t),cardQuote:{backgroundColor:e.palette.primary.light,textDecoration:"none",margin:"".concat(e.spacing.unit,"px 0"),padding:"".concat(e.spacing.unit,"px")},nameTitle:{fontWeight:500,fontSize:"2rem"},moreQuotesButton:{width:"auto",alignSelf:"center",marginTop:50,marginLeft:-12,marginRight:20},rightIcon:{marginLeft:e.spacing.unit}})})(Ke),_e=function(e){function t(){return Object(f.a)(this,t),Object(y.a)(this,Object(j.a)(t).apply(this,arguments))}return Object(E.a)(t,e),Object(b.a)(t,[{key:"render",value:function(){var e=this.props.classes;return n.createElement("div",null,n.createElement("div",{className:e.odd},n.createElement(te,null)),n.createElement("div",{className:e.even},n.createElement(ne,null)),n.createElement("div",{className:e.odd},n.createElement(ie,{title:"My Apps",apps:We})),n.createElement("div",{className:e.even},n.createElement(ie,{title:"Other Projects",apps:Qe})),n.createElement("div",{className:e.odd},n.createElement(qe,{match:this.props.match,history:this.props.history,location:this.props.location})),n.createElement("div",{className:e.even},n.createElement(He,{match:this.props.match,history:this.props.history,location:this.props.location})))}}]),t}(n.Component),ze=Object(s.withStyles)(function(e){return Object(s.createStyles)({odd:{backgroundColor:e.palette.primary.light},even:{backgroundColor:e.palette.primary.main}})})(_e),Ue=function(e){function t(e){var a;return Object(f.a)(this,t),(a=Object(y.a)(this,Object(j.a)(t).call(this,e))).state={quotes:new Array,loading:!0},a.fetchQuotes(),a}return Object(E.a)(t,e),Object(b.a)(t,[{key:"render",value:function(){var e=this.props,t=e.match,a=e.classes,r=this.state,o=r.quotes,c=r.loading;return n.createElement("div",{className:a.root},c&&n.createElement(l.e,{item:!0,sm:12},n.createElement(l.j,{variant:"h5"},"Loading...")),o.map(function(e){return n.createElement(l.c,{className:a.cardQuote,component:function(a){return n.createElement(v.a,Object.assign({},a,{to:"".concat(t.url,"/").concat(e.hash)}))}},n.createElement(l.j,{variant:"body1"},e.text," ~",e.author))}))}},{key:"fetchQuotes",value:function(){var e=Object(d.a)(h.a.mark(function e(){var t;return h.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,O.fetchAllQuotes();case 3:t=e.sent,this.setState({quotes:t,loading:!1}),e.next=11;break;case 7:e.prev=7,e.t0=e.catch(0),console.error(e.t0),this.setState({loading:!1});case 11:case"end":return e.stop()}},e,this,[[0,7]])}));return function(){return e.apply(this,arguments)}}()}]),t}(n.Component),Je=Object(s.withStyles)(function(e){var t;return Object(s.createStyles)({root:(t={width:"auto",marginLeft:3*e.spacing.unit,marginRight:3*e.spacing.unit},Object(x.a)(t,e.breakpoints.up(1100+3*e.spacing.unit*2),{width:1100,marginLeft:"auto",marginRight:"auto"}),Object(x.a)(t,"display","flex"),Object(x.a)(t,"flexWrap","wrap"),Object(x.a)(t,"flexGrow",1),Object(x.a)(t,"flexDirection","column"),Object(x.a)(t,"justifyContent","space-around"),Object(x.a)(t,"overflow","hidden"),Object(x.a)(t,"padding","".concat(8*e.spacing.unit,"px 0")),t),cardQuote:{textDecoration:"none",margin:"".concat(e.spacing.unit,"px 0"),padding:"".concat(e.spacing.unit,"px")}})})(Ue),Ze=Object(s.createMuiTheme)({palette:{type:"light",primary:{main:"#f7f7f7",light:"#ffffff",dark:"#c4c4c4"},secondary:{main:"#3dacd1",light:"#CEEBF6",dark:"#3dacd1"},text:{primary:"#5b6a72"}},typography:{useNextVariants:!0}}),Ye=function(){return i.b.set({page:window.location.pathname}),i.b.pageview(window.location.pathname),null},$e=function(){return r.a.createElement("div",null,r.a.createElement(l.j,{variant:"h2"},"Whoops"),r.a.createElement(l.j,{variant:"body1"},"Sorry but ",window.location.pathname," didn\u2019t match any pages"))},Xe=function(){return r.a.createElement("h2",null,"About")},et=function(){return r.a.createElement(p.a,null,r.a.createElement(s.MuiThemeProvider,{theme:Ze},r.a.createElement(q,null,r.a.createElement(m.a,{path:"/",component:Ye}),r.a.createElement(u.a,null,r.a.createElement(m.a,{exact:!0,path:"/",component:ze}),r.a.createElement(m.a,{path:"/about",component:Xe}),r.a.createElement(m.a,{path:"/books",component:N}),r.a.createElement(m.a,{path:"/quotes",component:Je}),r.a.createElement(m.a,{component:$e})))))};a(317),Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));i.b.initialize("UA-123888398-1"),c.a.render(r.a.createElement(et,null),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then(function(e){e.unregister()})},90:function(e,t,a){},98:function(e,t,a){e.exports=a.p+"static/media/logo.048a4a34.png"}},[[214,1,2]]]);
//# sourceMappingURL=main.4161ba08.chunk.js.map