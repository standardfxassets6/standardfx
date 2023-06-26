const swiper = new Swiper(".swiper", {
  // Optional parameters
  direction: "horizontal",
  loop: true,
  speed: 1200,
  autoplay: {
    delay: 10000,
  },
  // on: {
  //   slideChangeTransitionStart: function () {
  //     // Slide captions
  //     var swiper = this;
  //     setTimeout(function () {
  //       var currentTitle = $(swiper.slides[swiper.activeIndex]).attr(
  //         "data-title"
  //       );
  //       var currentSubtitle = $(swiper.slides[swiper.activeIndex]).attr(
  //         "data-subtitle"
  //       );
  //     }, 500);
  //     gsap.to($(".current-title"), 0.4, {
  //       autoAlpha: 0,
  //       y: -40,
  //       ease: Power1.easeIn,
  //     });
  //     gsap.to($(".current-subtitle"), 0.4, {
  //       autoAlpha: 0,
  //       y: -40,
  //       delay: 0.15,
  //       ease: Power1.easeIn,
  //     });
  //     gsap.to($(".btn"), 0.4, {
  //       autoAlpha: 0,
  //       y: -10,
  //       delay: 0.5,
  //       ease: Power1.easeIn,
  //     });
  //     gsap.to($(".btn-2"), 0.4, {
  //       autoAlpha: 0,
  //       y: -10,
  //       delay: 0.8,
  //       ease: Power1.easeIn,
  //     });
  //   },
  //   slideChangeTransitionEnd: function () {
  //     // Slide captions
  //     var swiper = this;
  //     var currentTitle = $(swiper.slides[swiper.activeIndex]).attr(
  //       "data-title"
  //     );
  //     var currentSubtitle = $(swiper.slides[swiper.activeIndex]).attr(
  //       "data-subtitle"
  //     );
  //     var currentAction = $(swiper.slides[swiper.activeIndex]).attr(
  //       "data-action"
  //     );
  //     console.log(currentAction);
  //     $(".slide-captions").html(function () {
  //       return `<h2 class='current-title'>${currentTitle}</h2><h3 class='current-subtitle'>${currentSubtitle}</h3>
  //       <div><div class="tatsu-module tatsu-normal-button tatsu-button-wrap tatsu-fzs0vfojy48pbako btn">
  //             <a class="tatsu-shortcode mediumbtn tatsu-button left-icon rounded bg-animation-none" href="./get-started.html"
  //               aria-label="View More" data-gdpr-atts="{}">GET STARTED</a>
  //             <style>
  //             .tatsu-v-kCFfz9Q .tatsu-button {
  //                 background-color: #ffffff;
  //                 color: rgb(0, 39, 21);
  //                 margin-top: 8px;
  //               }
  //             </style>
  //           </div></div>
  //       <div><div class="tatsu-module tatsu-normal-button tatsu-button-wrap tatsu-v-kCFfz9Q btn-2">
  //         <a class="tatsu-shortcode mediumbtn tatsu-button left-icon rounded bg-animation-none" href="./about.html"
  //           aria-label="View More" data-gdpr-atts="{}">LEARN MORE</a>
  //         <style>
  //           .tatsu-fzs0vfojy48pbako .tatsu-button {
  //             background-color : rgb(0, 39, 21);
  //             color: #ffffff;
  //             margin-top: 32px;
  //           }
  //         </style>
  //       </div></div>`;
  //     });
  //     gsap.from($(".current-title"), 0.4, {
  //       autoAlpha: 0,
  //       y: 40,
  //       ease: Power1.easeOut,
  //     });
  //     gsap.from($(".current-subtitle"), 0.4, {
  //       autoAlpha: 0,
  //       y: 40,
  //       delay: 0.15,
  //       ease: Power1.easeOut,
  //     });
  //     gsap.from($(".btn"), 0.4, {
  //       autoAlpha: 0,
  //       y: 10,
  //       delay: 0.5,
  //       ease: Power1.easeOut,
  //     });
  //     gsap.from($(".btn-2"), 0.4, {
  //       autoAlpha: 0,
  //       y: 10,
  //       delay: 0.8,
  //       ease: Power1.easeOut,
  //     });
  //   },
  // },
});

// Slide captions
// var currentTitle = $(mySwiper.slides[mySwiper.activeIndex]).attr("data-title");
// var currentSubtitle = $(mySwiper.slides[mySwiper.activeIndex]).attr(
//   "data-subtitle"
// );
// var currentAction = $(mySwiper.slides[mySwiper.activeIndex]).attr(
//   "data-action"
// );
// $(".slide-captions").html(function () {
//   return `<h2 class='current-title'>${currentTitle}</h2><h3 class='current-subtitle'>${currentSubtitle}</h3>
//   <div><div class="tatsu-module tatsu-normal-button tatsu-button-wrap tatsu-fzs0vfojy48pbako btn">
//         <a class="tatsu-shortcode mediumbtn tatsu-button left-icon rounded bg-animation-none" href="./about.html"
//           aria-label="View More" data-gdpr-atts="{}">GET STARTED</a>
//         <style>
//         .tatsu-v-kCFfz9Q .tatsu-button {
//             background-color: #ffffff;
//             color: rgb(0, 39, 21);
//             margin-top: 8px;
//           }
//         </style>
//       </div></div>
//   <div><div class="tatsu-module tatsu-normal-button tatsu-button-wrap tatsu-v-kCFfz9Q btn-2">
//     <a class="tatsu-shortcode mediumbtn tatsu-button left-icon rounded bg-animation-none" href="./get-started.html"
//       aria-label="View More" data-gdpr-atts="{}">LEARN MORE</a>
//     <style>
//       .tatsu-fzs0vfojy48pbako .tatsu-button {
//         background-color : rgb(0, 39, 21);
//         color: #ffffff;
//         margin-top: 32px;
//       }
//     </style>
//   </div></div>`;
// });
