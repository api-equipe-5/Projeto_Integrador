var data = [
    {
        id: "1",
        text: "Chairman & CEO",
        title: "Henry Bennett",
        img: "../common/img/avatar-1.png"
    },
    {
        id: "2",
        text: "Manager",
        title: "Mildred Kim",
        img: "../common/img/avatar-2.png"
    },
    {
        id: "3",
        text: "Technical Director",
        title: "Jerry Wagner",
        img: "../common/img/avatar-3.png"
    },
    { id: "1-2", from: "1", to: "2", type: "line" },
    { id: "1-3", from: "1", to: "3", type: "line" }
];
 
var diagram = new dhx.Diagram("diagram_container", { type: "org" });
diagram.data.parse(data);