<template>
<router-view></router-view>
</template>

<script>
import M from "materialize-css";

export default {
    name: "App",
    mounted() {
        M.AutoInit();
    },
};
</script>

<style>
body {
    font-family: "Roboto", sans-serif;
}

@keyframes showUp {
    0% {
        transform: scale(0);
    }

    100% {
        transform: scale(1);
    }
}

@keyframes showOff {
    0% {
        transform: scale(1);
    }

    100% {
        transform: scale(0);
    }
}

.scrolable {
    height: 400px;
    overflow: auto;
}

.pop {
    animation: showUp 0.5s cubic-bezier(0.18, 1.3, 1, 1) forwards;
}

.popOut {
    animation: showOff 0.5s cubic-bezier(0.18, 1.3, 1, 1) backwards;
}

.side-nav li.active {
    background-color: #00bcd4 !important;
}

.side-nav li.user-li.active {
    background-color: #ac3973 !important;
}

.side-nav li.active.lone a,
.side-nav li.active ul li:first-child,
.side-nav li.active.lone a svg,
.side-nav li.active ul li div.collapsible-header p svg {
    color: #ac3973 !important;
}

.preloader-background {
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: #eee;
    position: fixed;
    z-index: 100;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
}

@media only screen and (min-width: 1224px) {
    .teste {
        margin-left: 300px;
    }
}

.pagination li.active a {
    color: #fff;
    background-color: #66bb6a;
}

.pagination li a {
    color: #fff;
}

.highlight td {
    cursor: pointer;
}

.li_chats:hover {
    background-color: #eeeeee;
    cursor: pointer;
}

[type="checkbox"]+span:not(.lever):before,
[type="checkbox"]:not(.filled-in)+span:not(.lever):after {
    border: 2px solid white;
}

[type="checkbox"]:checked+span:not(.lever):before {
    border-right: 2px solid #66bb6a;
    border-bottom: 2px solid #66bb6a;
}

input:focus {
    border-bottom: 1px solid #66bb6a !important;
}

label.active {
    color: #66bb6a !important;
}

.input-field .prefix.active {
    color: #66bb6a;
}
</style>
