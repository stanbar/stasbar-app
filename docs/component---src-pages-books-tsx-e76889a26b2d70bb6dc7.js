(window.webpackJsonp=window.webpackJsonp||[]).push([[2],{ZcoD:function(t,e,a){"use strict";a.r(e);var n=a("o0o1"),o=a.n(n),r=(a("ls82"),a("E5k/"),a("Ll4R"),a("v9g0"),a("SUMQ")),i=a("DvoB"),s=a("q1tI"),c=a.n(s),l=a("axFy");s.Component;var p=function(t){var e,a;function n(){for(var e,a=arguments.length,n=new Array(a),o=0;o<a;o++)n[o]=arguments[o];return(e=t.call.apply(t,[this].concat(n))||this).state={books:new Array,loading:!0},e}a=t,(e=n).prototype=Object.create(a.prototype),e.prototype.constructor=e,e.__proto__=a;var r=n.prototype;return r.componentDidMount=function(){this.fetchBooks()},r.render=function(){var t=this.props.classes,e=this.state,a=e.books,n=e.loading;return c.a.createElement("div",{className:t.root},c.a.createElement(i.d,{container:!0,spacing:16},n&&c.a.createElement(i.d,{item:!0,sm:12},c.a.createElement(i.i,{variant:"h5"},"Loading...")),a.map((function(e){return c.a.createElement(i.d,{key:e.hash,item:!0,xs:4,sm:3,md:3,lg:2,style:{height:"auto",width:"100%"}},c.a.createElement(i.e,null,c.a.createElement("img",{src:e.imageUrl,alt:e.title,className:t.img}),c.a.createElement(i.f,{title:e.title,subtitle:c.a.createElement("span",null,"by: ",e.author)})))}))))},r.fetchBooks=function(){var t;return o.a.async((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,o.a.awrap(l.a.fetchAllBooks());case 3:t=e.sent,this.setState({books:t,loading:!1}),e.next=11;break;case 7:e.prev=7,e.t0=e.catch(0),console.error(e.t0),this.setState({loading:!1});case 11:case"end":return e.stop()}}),null,this,[[0,7]])},n}(s.Component);e.default=Object(r.withStyles)((function(t){var e;return Object(r.createStyles)({root:(e={width:"auto",marginLeft:3*t.spacing.unit,marginRight:3*t.spacing.unit},e[t.breakpoints.up(1100+3*t.spacing.unit*2)]={width:1100,marginLeft:"auto",marginRight:"auto"},e.display="flex",e.flexWrap="wrap",e.flexGrow=1,e.flexDirection="column",e.justifyContent="space-around",e.overflow="hidden",e.padding=8*t.spacing.unit+"px 0",e),img:{width:"100%",height:"auto"}})}))(p)}}]);
//# sourceMappingURL=component---src-pages-books-tsx-e76889a26b2d70bb6dc7.js.map